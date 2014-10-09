package iit.csp595.servlet;

import iit.csp595.bean.GenericPageBean;
import iit.csp595.bean.account.OrderListingBean;
import iit.csp595.domain.object.Order;
import iit.csp595.service.OrderService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    long productId = ServletUtils.toLong(request.getParameter("id"), -1);
    int nextPage = ServletUtils.toInt(request.getParameter("page"), 1);
    int sortTypeId = ServletUtils.toInt(request.getParameter("s"));

    GenericPageBean<Order> bean = new OrderService(productId, nextPage, sortTypeId).createBean();

    if (productId == -1) {
      request.setAttribute("bean", bean);
      request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
    } else {

      // For now lets assume that all message are bad and if there is one then it must be an error message
      if (bean.getMessage() != null) {
        response.sendRedirect("order");
      } else {
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      }
    }
  }
}
