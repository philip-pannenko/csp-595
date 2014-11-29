package iit.csp595.servlet;

import iit.csp595.Utils;
import iit.csp595.domain.dao.ProductDao;
import iit.csp595.domain.model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    PrintWriter out = response.getWriter();

    String search = request.getParameter("s");

    if (search != null && !search.trim().isEmpty()) {
      ProductDao dao = new ProductDao();
      List<Product> products = dao.findProducts(search.trim());
      out.println(Utils.opeanAndCreateTableHeader());
      if (products == null || products.isEmpty()) {
        out.println(Utils.createTableData("No Results Found!"));
      } else {
        for (Product p : products) {
          out.println(Utils.createTableData(Utils.createAnchor("product?p=" + p.getId(), p.getName())));
        }
      }
      out.println(Utils.closeTable());
    }
  }
}
