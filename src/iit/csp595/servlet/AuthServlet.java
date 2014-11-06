package iit.csp595.servlet;

import iit.csp595.Actions;
import iit.csp595.Constants;
import iit.csp595.Utils;
import iit.csp595.bean.LoginPageBean;
import iit.csp595.domain.dao.UserDao;
import iit.csp595.domain.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int action = Utils.toInt(request.getParameter("a"));
    switch (Actions.getAction(action)) {
    case LOGOUT:
      Utils.setAuthUser(request, null);
      response.sendRedirect("?" + Utils.generateInfoMsg(Constants.MSG_LOGGED_OUT));
      break;
    default:
      request.setAttribute("bean", new LoginPageBean());
      request.getRequestDispatcher("WEB-INF/template.jsp").forward(request, response);
      break;
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int action = Utils.toInt(request.getParameter("a"));
    switch (Actions.getAction(action)) {
    case LOGIN:

      String username = request.getParameter("username");
      String password = request.getParameter("password");

      UserDao dao = new UserDao();
      User user = dao.login(username, password.toCharArray());

      if (user != null) {
        Utils.setAuthUser(request, user);
        response.sendRedirect("product?" + Utils.generateInfoMsg(Constants.MSG_LOGGED_IN));
      } else {
        response.sendRedirect("auth?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_CREDENTIALS));
      }
      break;
    default:
      response.sendRedirect("auth?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_ACTION));
      break;
    }
  }

}
