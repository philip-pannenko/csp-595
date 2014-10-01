package iit.csp595.servlet.auth;

import iit.csp595.domain.User;
import iit.csp595.domain.dao.UserDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    UserDao dao = new UserDao();
    User user = dao.login(username, password.toCharArray());
    
    request.removeAttribute("error");
    
    if(user != null) {
      request.getSession().setAttribute("user", user);
      response.sendRedirect("product");
    } else {
      request.setAttribute("error", "Invalid Credentials!");
      request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }
  }

}
