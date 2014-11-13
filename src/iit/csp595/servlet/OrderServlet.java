package iit.csp595.servlet;

import iit.csp595.Actions;
import iit.csp595.Constants;
import iit.csp595.Utils;
import iit.csp595.bean.OrderIndividualBean;
import iit.csp595.bean.OrderListingBean;
import iit.csp595.domain.dao.OrderDao;
import iit.csp595.domain.model.Order;
import iit.csp595.domain.model.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    long orderId = Utils.toLong(request.getParameter("id"));
    int nextPage = Utils.toInt(request.getParameter("p"), 1);
    int sortTypeId = Utils.toInt(request.getParameter("s"));

    OrderDao dao = new OrderDao();
    User user = Utils.getAuthUser(request);
    if (orderId == -1) {

      if (user != null) {

        int offset = nextPage - 1;
        int totalProductsCount = dao.getCount(sortTypeId);
        List<Order> products = dao.getAllForUser(offset * Constants.ITEMS_PER_PAGE, Constants.ITEMS_PER_PAGE, sortTypeId, user.getId());
        OrderListingBean bean = new OrderListingBean(products, totalProductsCount);
        bean.setCurrentPage(nextPage);
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      } else {
        response.sendRedirect("../?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_CREDENTIALS));
      }

    } else {
      Order p = dao.get(orderId);
      if (p == null) {
        response.sendRedirect("order?" + Utils.generateErrorMsg(Constants.ERROR_ORDER_NOT_FOUND, request.getParameter("id")));
      } else {
        if(Utils.isUsersEqual(p.getUser(), user)) { 
          request.setAttribute("bean", new OrderIndividualBean(p));
          request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
        } else {
          response.sendRedirect("../?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_CREDENTIALS));
        }
      }
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int actionId = Utils.toInt(request.getParameter("a"));
    long orderId = Utils.toLong(request.getParameter("o"));
    switch (Actions.getAction(actionId)) {
    case CANCEL_ORDER:
      OrderDao dao = new OrderDao();
      Order order = dao.get(orderId);
      if (order == null) {
        response.sendRedirect("order?" + Utils.generateErrorMsg(Constants.ERROR_ORDER_NOT_FOUND));
      } else {
        if(!Utils.isOrderCancelable(order.getDeliveryDate())) {
          response.sendRedirect("order?" + Utils.generateErrorMsg(Constants.ERROR_ORDER_CANNOT_BE_CANCELLED, request.getParameter("id")));
        } else {
          dao.cancelOrder(orderId);
          response.sendRedirect("order?" + Utils.generateInfoMsg(Constants.MSG_ORDER_CANCELLED));
        }
      }
      break;
    default:
      response.sendRedirect("order?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_ACTION));
      break;
    }
  }
}
