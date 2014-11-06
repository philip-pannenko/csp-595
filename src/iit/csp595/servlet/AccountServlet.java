package iit.csp595.servlet;

import iit.csp595.Utils;
import iit.csp595.bean.AccountPageBean;
import iit.csp595.domain.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = Utils.getAuthUser(request);
    AccountPageBean bean = new AccountPageBean(user);
    request.setAttribute("bean", bean);
    request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
  }
}
