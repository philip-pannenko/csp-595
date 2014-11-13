package iit.csp595.bean;

import iit.csp595.domain.model.User;

import java.io.Serializable;

public class SignUpPageBean extends GenericIndividualPageBean<User> implements Serializable {

  public SignUpPageBean(User item) {
    super(item, "pages/sign-up-page.jsp", null);
  }
}
