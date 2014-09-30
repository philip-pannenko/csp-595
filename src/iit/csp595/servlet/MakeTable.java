package iit.csp595.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeTable extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>Make Table</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Make Table</h1>");

    out.println("<table cellspacing='5' cellpadding='5' border='1px'>");
    for (int i = 1; i < 26; i++) {
      out.print("<tr>");
      for (int j = 1; j < 4; j++) {
        out.print("<th> Row " + i + ", Column 3-p" + j + "</th>");
      }
      out.println("</tr>");
    }
    out.println("</table>");

    out.println("</body>");
    out.println("</html>");

    out.close();
  }

}
