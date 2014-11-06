package iit.csp595.servlet;

import iit.csp595.Actions;
import iit.csp595.Constants;
import iit.csp595.Utils;
import iit.csp595.bean.cart.CartIndividualBean;
import iit.csp595.domain.model.Cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
      // Cart cart = Utils.getCart(request);
      // User user = Utils.getAuthUser(request);
      //
      // String name = request.getParameter("name");
      // String street = request.getParameter("street");
      // String city = request.getParameter("city");
      // String state = request.getParameter("state");
      // String zip = request.getParameter("zip");
      // String creditCardExpirationDate = request.getParameter("creditCardExpirationDate");
      // String creditCardNumber = request.getParameter("creditCardNumber");
      //
      // if (Utils.isNullOrEmpty(name, street, city, zip, creditCardExpirationDate, creditCardNumber)) {
      // response.sendRedirect("cart?" + Constants.ERROR_MISSING_FORM_DATA);
      // } else if (cart.getProducts().isEmpty()) {
      // response.sendRedirect("cart?" + Constants.ERROR_CART_EMPTY);
      // } else if (user == null) {
      // response.sendRedirect("cart?" + Constants.ERROR_NOT_LOGGED_IN);
      // } else {
      // OrderDao dao = new OrderDao();
      //
      // Calendar deliveryDate = Calendar.getInstance();
      // deliveryDate.add(Calendar.WEEK_OF_YEAR, 2);
      //
      // Order order = new Order(Database.ORDER_SEQ_ID++, cart.getProducts(), Calendar.getInstance().getTime(), deliveryDate.getTime(), user, name, street, city, state, zip,
      // creditCardExpirationDate, creditCardNumber);
      // dao.createOrder(order);
      // Utils.clearCart(request);
      // response.sendRedirect("order?o=" + order.getId() + "&" + Constants.MSG_ORDER_COMPLETE);
      // }
      break;

    case CONFIRM_ORDER:

      // Cart cart1 = Utils.getCart(request);
      // User user1 = Utils.getAuthUser(request);
      //
      // if (cart1.getProducts().isEmpty()) {
      // response.sendRedirect("cart?" + Constants.ERROR_CART_EMPTY);
      // } else if (user1 == null) {
      // response.sendRedirect("cart?" + Constants.ERROR_NOT_LOGGED_IN);
      // }
      //
      // response.setContentType("text/html");
      //
      // PrintWriter out = response.getWriter();
      //
      // out.println(Utils.getHeader());
      // out.println(Utils.getNav(request));
      // out.println(Utils.openAndCreateForm("cart?a=8"));
      // out.println(Utils.opeanAndCreateTableHeader());
      // out.println(Utils.createTableData("Name", "<input name='name'/>"));
      // out.println(Utils.createTableData("Street", "<input name='street'/>"));
      // out.println(Utils.createTableData("City", "<input name='city'/>"));
      // out.println(Utils.createTableData("State", "<input name='state'/>"));
      // out.println(Utils.createTableData("Zip", "<input name='zip'/>"));
      // out.println(Utils.createTableData("Credit Card Number", "<input name='creditCardNumber'/>"));
      // out.println(Utils.createTableData("Credit Card Expiration Date", "<input name='creditCardExpirationDate'/>"));
      //
      // out.println(Utils.createTableData("<input type='submit' value='Submit Order'/>"));
      // out.println(Utils.closeTable());
      // out.println(Utils.closeForm());
      // out.println(Utils.getFooter());
      //
      break;

    default:
      response.sendRedirect("cart?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_ACTION));
      break;
    }

  }

}
