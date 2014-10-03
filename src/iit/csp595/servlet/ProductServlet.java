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

    long productId = ServletUtils.toLong(request.getParameter("id"), -1);

    ProductDao dao = new ProductDao();

    if (productId == -1) {

      long[] categoryTypeId = ServletUtils.toLong(request.getParameter("c"));

      int nextPage = ServletUtils.toInt(request.getParameter("page"), 1);

      int offset = nextPage - 1;
      int totalProductsCount = dao.getCount(categoryTypeId);
      List<Product> products = dao.getAll(offset * 2, 2, categoryTypeId);
      ProductListingBean bean = new ProductListingBean(products, null, totalProductsCount);

      bean.setCurrentPage(nextPage);
      bean.setCurrentCategories(categoryTypeId);

      request.setAttribute("bean", bean);
      request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
    } else {

      Product product = dao.get(productId);
      if (product == null) {
        response.sendRedirect("product");
      } else {
        request.setAttribute("bean", new ProductIndividualBean(product));
        request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
      }
    }
  }

}
