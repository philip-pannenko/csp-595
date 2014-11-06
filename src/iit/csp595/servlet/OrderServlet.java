package iit.csp595.servlet;

import iit.csp595.Constants;
import iit.csp595.Utils;
import iit.csp595.bean.Message;
import iit.csp595.bean.OrderIndividualBean;
import iit.csp595.bean.OrderListingBean;
import iit.csp595.domain.dao.OrderDao;
import iit.csp595.domain.model.Order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    long productId = Utils.toLong(request.getParameter("id"));
    int nextPage = Utils.toInt(request.getParameter("p"), 1);
    int sortTypeId = Utils.toInt(request.getParameter("s"));

    OrderDao dao = new OrderDao();

    if (productId == -1) {
      int offset = nextPage - 1;
      int totalProductsCount = dao.getCount(sortTypeId);
      List<Order> products = dao.getAll(offset * 2, 2, sortTypeId);
      OrderListingBean bean = new OrderListingBean(products, totalProductsCount);
      bean.setCurrentPage(nextPage);
      request.setAttribute("bean", bean);
      request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
    } else {
      Order p = dao.get(productId);
      OrderIndividualBean bean = new OrderIndividualBean(p);

      if (p == null) {
        bean.setMessage(Message.createError(Constants.ERROR_ORDER_NOT_FOUND));
        response.sendRedirect("order");
      }
      request.setAttribute("bean", bean);
      request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
    }
  }
}
