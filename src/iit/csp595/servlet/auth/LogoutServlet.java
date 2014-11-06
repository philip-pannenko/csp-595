package iit.csp595.servlet.auth;

import iit.csp595.Constants;
import iit.csp595.Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getSession().removeAttribute("user");
    response.sendRedirect("?" + Utils.generateInfoMsg(Constants.MSG_LOGGED_OUT));
  }

}
