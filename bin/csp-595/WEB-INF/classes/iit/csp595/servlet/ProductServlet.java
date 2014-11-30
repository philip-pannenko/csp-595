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
import java.io.PrintWriter;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

  private static NumberFormat formatter = NumberFormat.getCurrencyInstance();

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    long productId = Utils.toLong(request.getParameter("id"));
    long[] categoryTypeId = Utils.toLongArray(request.getParameter("c"));
    int nextPage = Utils.toInt(request.getParameter("p"), 1);
    int sortTypeId = Utils.toInt(request.getParameter("so"));
    String search = Utils.trim(request.getParameter("se"));
    boolean isAjax = Utils.toBoolean(request.getParameter("a"));

    ProductDao dao = new ProductDao();

    // listing
    if (productId == -1) {

      int offset = nextPage - 1;
      SearchResult results = dao.getAll(offset * Constants.ITEMS_PER_PAGE, Constants.ITEMS_PER_PAGE, categoryTypeId, sortTypeId, search);
      ProductListingBean bean = new ProductListingBean(results.items, null, results.count);

      bean.setCurrentPage(nextPage);
      bean.setCurrentCategories(categoryTypeId);

      if (isAjax) {
        buildAjaxPage(response, bean, search, sortTypeId);
      } else {
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      }
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
        Utils.incrementCartCount(request);
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

  private void buildAjaxPage(HttpServletResponse response, ProductListingBean bean, String search, int sortTypeId) throws IOException {
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    PrintWriter out = response.getWriter();

    String baseUrl = "?c=" + bean.getParsedCurrentCategories() + (search == null ? "" : "&se=" + search) + "&a=1";
    String paginationUrl = baseUrl + "&so=" + sortTypeId;
    String sortItemUrl = baseUrl + "&so=" + (sortTypeId == 3 ? 4 : 3);
    String sortPriceUrl = baseUrl + "&so=" + (sortTypeId == 1 ? 2 : 1);

    out.println("<input type='hidden' id='sortItemUrl' name='sortItemUrl' value='" + sortItemUrl + "'/>");
    out.println("<input type='hidden' id='sortPriceUrl' name='sortPriceUrl' value='" + sortPriceUrl + "'/>");
    out.println("<input type='hidden' id='paginationUrl' name='paginationUrl' value='" + paginationUrl + "'/>");
    
    out.println("<table class='table'> ");
    out.println("<tbody> ");
    out.println("<tr> ");
    out.println("<th class='col'></th> ");
    out.println("<th class='col'><a onmouseup='doAjaxForItem()'>Item &#x25B4;&#x25BE;</a></th> ");
    out.println("<th class='col col_descrip_list'>Description</th> ");
    out.println("<th class='col col_price_list'><a onmouseup='doAjaxForPrice()'>Price &#x25B4;&#x25BE;</a></th>");
    out.println("</tr> ");

    for (Product p : bean.getItems()) {
      out.println("<tr> ");
      out.println("<td><img class='group' src='images/product/" + p.getId() + ".jpg'></td> ");
      out.println("<td><a href='product?id=" + p.getId() + "'> " + p.getName() + "</a></td> ");
      out.println("<td><p> " + p.getDescription().substring(0, p.getDescription().length() < 500 ? p.getDescription().length() : 500) + "...</p></td> ");
      out.println("<td class='cell_price'> " + formatter.format(p.getPrice()) + "</td> ");
      out.println("</tr> ");
    }
    out.println("</tbody> ");
    out.println("</table> ");

    out.println("<div style='text-align: center;' class='pagination'>");
    out.println("<nav>");
    out.println("<ul>");

    // Pagination bar
    for (int i = 1; i <= bean.getTotalPages(); i++) {
      out.println("<li class='" + (bean.getCurrentPage() == i ? "active" : "") + "'>");
      out.println("<a style='cursor:pointer;' onmouseup='doAjaxForPagination(" + i + ")'> " + i + " </a>");
      out.println("</li>");
    }

    out.println("</ul>");
    out.println("</nav>");
    out.println("</div>");

  }
}
