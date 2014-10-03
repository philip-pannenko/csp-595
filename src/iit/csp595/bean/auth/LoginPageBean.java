package iit.csp595.bean.auth;

import java.io.Serializable;

import iit.csp595.bean.GenericPageBean;
import iit.csp595.domain.Message;
import iit.csp595.domain.account.User;

public class LoginPageBean extends GenericPageBean<User> implements Serializable {

  private static final long serialVersionUID = 1L;

  public LoginPageBean() {
    super("pages/login.jsp", null);
  }

  public LoginPageBean(Message message) {
    super("pages/login.jsp", message);
  }

}
