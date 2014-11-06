package iit.csp595.bean.auth;

import java.io.Serializable;

import iit.csp595.bean.GenericPageBean;
import iit.csp595.domain.model.User;

public class LoginPageBean extends GenericPageBean<User> implements Serializable {

  public LoginPageBean() {
    super("pages/login.jsp", null);
  }

}
