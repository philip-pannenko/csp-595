package iit.csp595.servlet;

import iit.csp595.Actions;
import iit.csp595.Constants;
import iit.csp595.Utils;
import iit.csp595.bean.CartIndividualBean;
import iit.csp595.bean.CheckoutPageBean;
import iit.csp595.bean.Message;
import iit.csp595.domain.Database;
import iit.csp595.domain.dao.OrderDao;
import iit.csp595.domain.model.Cart;
import iit.csp595.domain.model.Order;
import iit.csp595.domain.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class CartServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Cart cart = Utils.getCart(request);
    CartIndividualBean bean = new CartIndividualBean(cart);
    request.setAttribute("bean", bean);
    request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int actionId = Utils.toInt(request.getParameter("a"));
    long productId = Utils.toLong(request.getParameter("p"));

    switch (Actions.getAction(actionId)) {
    case DECREASE_COUNT:
      if (productId != -1) {
        Cart cart = Utils.getCart(request);

        if (cart.getProducts().containsKey(productId)) {
          int counter = cart.getProducts().get(productId);
          if (counter == 1) {
            cart.getProducts().remove(productId);
          } else {
            cart.getProducts().put(productId, --counter);
          }
        }
        response.sendRedirect("cart?" + Utils.generateInfoMsg(Constants.MSG_CART_PRODUCT_DECREMENTED));
      } else {
        response.sendRedirect("cart?" + Utils.generateErrorMsg(Constants.ERROR_PRODUCT_NOT_FOUND, request.getParameter("p")));
      }
      break;
    case INCREASE_COUNT:
      if (productId != -1) {
        Cart cart = Utils.getCart(request);
        if (!cart.getProducts().containsKey(productId)) {
          cart.getProducts().put(productId, 1);
        } else {
          int counter = cart.getProducts().get(productId);
          cart.getProducts().put(productId, ++counter);
        }
        response.sendRedirect("cart?" + Utils.generateInfoMsg(Constants.MSG_CART_PRODUCT_INCREMENTED));
      } else {
        response.sendRedirect("cart?" + Utils.generateErrorMsg(Constants.ERROR_PRODUCT_NOT_FOUND, request.getParameter("p")));
      }
      break;
    case REMOVE_FROM_CART:
      if (productId != -1) {
        Cart cart = Utils.getCart(request);
        if (cart.getProducts().containsKey(productId)) {
          cart.getProducts().remove(productId);
        }
        response.sendRedirect("cart?" + Utils.generateInfoMsg(Constants.MSG_PRODUCT_REMOVED_FROM_CART));
      } else {
        response.sendRedirect("cart?" + Utils.generateErrorMsg(Constants.ERROR_PRODUCT_NOT_FOUND, request.getParameter("p")));
      }

      break;
    case SUBMIT_ORDER:
      Cart cart = Utils.getCart(request);
      User user = new User();

      if (cart.getProducts().isEmpty()) {
        response.sendRedirect("cart?" + Utils.generateErrorMsg(Constants.ERROR_CART_IS_EMPTY));
      } else {
        try {
          BeanUtils.populate(user, request.getParameterMap());
          User authUser = Utils.getAuthUser(request);
          user.setId(authUser == null ? -1L : authUser.getId());
        } catch (IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
        
        

        if (!Utils.validateUserForm(user)) {
          CheckoutPageBean checkoutBean = new CheckoutPageBean(user);
          checkoutBean.setMessage(new Message(true, Constants.ERROR_VALIDATION_FAILED));
          request.setAttribute("bean", checkoutBean);
          request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
        } else {

          OrderDao dao = new OrderDao();
          Calendar deliveryDate = Calendar.getInstance();
          deliveryDate.add(Calendar.WEEK_OF_YEAR, 2);

          Order order = new Order(++Database.ORDER_SEQ_ID, "", Calendar.getInstance().getTime(), deliveryDate.getTime(), cart.getTotalCost(), cart.getProducts(), user);
          dao.createOrder(order);
          Utils.clearCart(request);
          response.sendRedirect("account/order?id=" + order.getId() + "&" + Utils.generateInfoMsg(Constants.MSG_ORDER_COMPLETE));
        }
      }
      break;
    case CLEAR_CART:
      Utils.clearCart(request);
      response.sendRedirect("cart?" + Utils.generateInfoMsg(Constants.MSG_CART_CLEARED));
      break;
    case CONFIRM_ORDER:
      if (Utils.getCart(request).getProducts().isEmpty()) {
        response.sendRedirect("cart?" + Utils.generateErrorMsg(Constants.ERROR_CART_IS_EMPTY));
      } else {
        CheckoutPageBean checkoutBean = new CheckoutPageBean(Utils.getAuthUser(request));
        request.setAttribute("bean", checkoutBean);
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      }
      break;
    default:
      response.sendRedirect("cart?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_ACTION));
      break;
    }

  }

}
