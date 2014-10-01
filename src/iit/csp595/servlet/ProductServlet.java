package iit.csp595.servlet;

import iit.csp595.bean.product.ProductIndividualBean;
import iit.csp595.bean.product.ProductListingBean;
import iit.csp595.domain.Product;
import iit.csp595.domain.dao.TempDB;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String productId = request.getParameter("id");

    if (productId == null) {
      List<Product> products = TempDB.productsList;
      request.setAttribute("bean", new ProductListingBean(products));
      request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
    } else {
      Product product = TempDB.products.get(Long.valueOf(productId));
      if (product == null) {
        response.sendRedirect("product");
      } else {
        request.setAttribute("bean", new ProductIndividualBean(product));
        request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
      }
    }
  }

}
