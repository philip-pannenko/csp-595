package iit.csp595.bean;

import java.io.Serializable;

public class LoginPageBean extends GenericPageBean implements Serializable {

  public LoginPageBean() {
    super("pages/login-page.jsp");
    super.setBrowserPageTitle("Login Page");
  }
}
