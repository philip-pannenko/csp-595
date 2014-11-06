package iit.csp595.servlet;

import iit.csp595.bean.SettingFormBean;
import iit.csp595.domain.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SettingServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    SettingFormBean bean = new SettingFormBean((User) request.getSession().getAttribute("user"));
    request.setAttribute("bean", bean);
    request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);

  }
}
