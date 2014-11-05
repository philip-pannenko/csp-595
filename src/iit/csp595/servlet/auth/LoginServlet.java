package iit.csp595.servlet.auth;

import iit.csp595.Constants;
import iit.csp595.bean.Message;
import iit.csp595.bean.auth.LoginPageBean;
import iit.csp595.domain.dao.UserDao;
import iit.csp595.domain.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("bean", new LoginPageBean());
    request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    UserDao dao = new UserDao();
    User user = dao.login(username, password.toCharArray());

    if (user != null) {
      request.getSession().setAttribute("user", user);
      response.sendRedirect("product");
    } else {
      request.setAttribute("bean", new LoginPageBean(new Message(true, Constants.ERROR_INVALID_CREDENTIALS)));
      request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
    }
  }

}
