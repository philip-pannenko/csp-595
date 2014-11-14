package iit.csp595.servlet;

import iit.csp595.Actions;
import iit.csp595.Constants;
import iit.csp595.Utils;
import iit.csp595.bean.ProductIndividualBean;
import iit.csp595.bean.ProductListingBean;
import iit.csp595.domain.dao.ProductDao;
import iit.csp595.domain.dao.ProductDao.SearchResult;
import iit.csp595.domain.model.Cart;
import iit.csp595.domain.model.Product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

public class ProductServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    long productId = Utils.toLong(request.getParameter("id"));
    long[] categoryTypeId = Utils.toLongArray(request.getParameter("c"));
    int nextPage = Utils.toInt(request.getParameter("p"), 1);
    int sortTypeId = Utils.toInt(request.getParameter("so"));
    String search = Utils.trim(request.getParameter("se"));
    
    ProductDao dao = new ProductDao();

    // listing
    if (productId == -1) {

      int offset = nextPage - 1;
      SearchResult results = dao.getAll(offset * Constants.ITEMS_PER_PAGE, Constants.ITEMS_PER_PAGE, categoryTypeId, sortTypeId, search);
      ProductListingBean bean = new ProductListingBean(results.items, null, results.count);

      bean.setCurrentPage(nextPage);
      bean.setCurrentCategories(categoryTypeId);

      request.setAttribute("bean", bean);
      request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);

    }

    // individual
    else {

      Product p = dao.get(productId);
      if (p == null) {
        response.sendRedirect("product?" + Utils.generateErrorMsg(Constants.ERROR_ORDER_NOT_FOUND));
      } else {
        request.setAttribute("bean", new ProductIndividualBean(p));
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      }
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int action = Utils.toInt(request.getParameter("a"));
    long p = Utils.toLong(request.getParameter("p"));
    switch (Actions.getAction(action)) {
    case ADD_TO_CART:
      if (p != -1) {
        Cart cart = Utils.getCart(request);
        if (!cart.getProducts().containsKey(p)) {
          cart.getProducts().put(p, 1);
        } else {
          int counter = cart.getProducts().get(p);
          cart.getProducts().put(p, ++counter);
        }
        response.sendRedirect("cart?" + Utils.generateInfoMsg(Constants.MSG_PRODUCT_ADDED_TO_CART));
      } else {
        response.sendRedirect("product?" + Utils.generateErrorMsg(Constants.ERROR_PRODUCT_NOT_FOUND));
      }
      break;
    default:
      response.sendRedirect("product?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_ACTION));
      break;
    }
  }
}
