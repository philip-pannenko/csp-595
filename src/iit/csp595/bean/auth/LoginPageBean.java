package iit.csp595.bean.auth;

import iit.csp595.bean.GenericPageBean;
import iit.csp595.domain.Message;
import iit.csp595.domain.User;

public class LoginPageBean extends GenericPageBean<User> {

  public LoginPageBean() {
    super("pages/login.jsp", null);
  }
  
  public LoginPageBean(Message message) {
    super("pages/login.jsp", message);
  }

  private static final long serialVersionUID = 1L;

}
