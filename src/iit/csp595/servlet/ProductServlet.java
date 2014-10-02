package iit.csp595.servlet;

import iit.csp595.bean.product.ProductIndividualBean;
import iit.csp595.bean.product.ProductListingBean;
import iit.csp595.domain.Product;
import iit.csp595.domain.dao.ProductDao;

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

      ProductDao dao = new ProductDao();
      List<Product> products;
      String nextPage = request.getParameter("page");
      ProductListingBean bean;
      if (nextPage != null) {
        int offset = Integer.parseInt(nextPage) - 1; // which index to start at
        offset *= 2; // multiple offset by page size
        int max = 2; // how many results per page
        products = dao.getAll(offset, max);
        int totalProductsCount = dao.getCount();
        bean = new ProductListingBean(products, totalProductsCount);

        bean.setCurrentPage(Integer.parseInt(nextPage));
      } else {
        products = dao.getAll(0, 2);
        int totalProductsCount = dao.getCount();
        bean = new ProductListingBean(products, totalProductsCount);
      }

      request.setAttribute("bean", bean);
      request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
    } else {
      ProductDao dao = new ProductDao();
      Product product = dao.get(Long.valueOf(productId));
      if (product == null) {
        response.sendRedirect("product");
      } else {
        request.setAttribute("bean", new ProductIndividualBean(product));
        request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
      }
    }
  }

}
