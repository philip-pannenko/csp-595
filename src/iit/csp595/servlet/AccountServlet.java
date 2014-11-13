package iit.csp595.servlet;

import iit.csp595.Actions;
import iit.csp595.Constants;
import iit.csp595.Utils;
import iit.csp595.bean.AccountPageBean;
import iit.csp595.bean.Message;
import iit.csp595.bean.SettingFormBean;
import iit.csp595.bean.SignUpPageBean;
import iit.csp595.domain.Database;
import iit.csp595.domain.dao.UserDao;
import iit.csp595.domain.model.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class AccountServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int action = Utils.toInt(request.getParameter("a"));
    User user = Utils.getAuthUser(request);

    switch (Actions.getAction(action)) {
    case NEW_ACCOUNT:
      request.setAttribute("bean", new SignUpPageBean(null));
      request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      break;

    case MODIFY_ACCOUNT:
      if (user == null) {
        response.sendRedirect("?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_CREDENTIALS));
      } else {
        request.setAttribute("bean", new SettingFormBean(user));
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      }
      break;
    default:
      if (user == null) {
        response.sendRedirect("?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_CREDENTIALS));
      } else {
        request.setAttribute("bean", new AccountPageBean(user));
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      }
      break;
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int action = Utils.toInt(request.getParameter("a"));
    UserDao dao = new UserDao();
    User user;
    switch (Actions.getAction(action)) {

    case MODIFY_ACCOUNT:
      user = new User();
      try {
        BeanUtils.populate(user, request.getParameterMap());
      } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }

      if (!Utils.validateUserForm(user) || !Utils.validateUserAccount(user) || !Utils.validatePassword(user, Utils.getAuthUser(request))) {
        SettingFormBean bean = new SettingFormBean(user);
        bean.setMessage(new Message(true, Constants.ERROR_VALIDATION_FAILED));
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      } else {

        dao.saveUser(user);
        // Update the user in our session to reflect these changes
        Utils.setAuthUser(request, user);
        response.sendRedirect("account?" + Utils.generateInfoMsg(Constants.MSG_USER_SAVED));
      }
      break;

    case NEW_ACCOUNT:
      user = new User();
      try {
        BeanUtils.populate(user, request.getParameterMap());
      } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }

      if (!Utils.validateUserForm(user) || !Utils.validateUserAccount(user)) {
        SignUpPageBean bean = new SignUpPageBean(user);
        bean.setMessage(new Message(true, Constants.ERROR_VALIDATION_FAILED));
        request.setAttribute("bean", bean);
        request.getRequestDispatcher("/WEB-INF/template.jsp").forward(request, response);
      } else {

        user.setId(++Database.USER_SEQ_ID);

        dao.saveUser(user);
        // Update the user in our session to reflect these changes
        Utils.setAuthUser(request, user);
        response.sendRedirect("account?" + Utils.generateInfoMsg(Constants.MSG_USER_SAVED));
      }
      break;
    case DELETE_ACCOUNT:
      user = Utils.getAuthUser(request);
      if (user == null) {
        response.sendRedirect("product?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_CREDENTIALS));
      } else {
        // Log the person out, remove the person from the db, redirect to login page
        Utils.setAuthUser(request, null);
        dao.deleteUser(user);
        response.sendRedirect("product?" + Utils.generateInfoMsg(Constants.MSG_USER_DELETED));
      }
      break;
    default:
      response.sendRedirect("account?" + Utils.generateErrorMsg(Constants.ERROR_INVALID_ACTION));
      break;
    }
  }
}
