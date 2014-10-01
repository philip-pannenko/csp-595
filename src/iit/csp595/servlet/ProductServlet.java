package iit.csp595.servlet;

import iit.csp595.domain.Product;
import iit.csp595.domain.dao.TempDB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String productId = request.getParameter("id");

    if (productId == null) {
      request.setAttribute("products", TempDB.products);
      request.getRequestDispatcher("WEB-INF/pages/product-listing.jsp").forward(request, response);
    } else {
      Product product = TempDB.products.get(Long.valueOf(productId));
      if (product == null) {
        response.sendRedirect("product");
      } else {
        request.setAttribute("product", product);
        request.getRequestDispatcher("WEB-INF/pages/product-individual.jsp").forward(request, response);
      }
    }
  }

}
