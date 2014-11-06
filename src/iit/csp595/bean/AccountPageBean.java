package iit.csp595.bean;

import iit.csp595.domain.model.User;

import java.io.Serializable;

public class AccountPageBean extends GenericPageBean implements Serializable {

  public AccountPageBean(User bean) {
    super("pages/account-page.jsp");
    super.setBrowserPageTitle("Account Page");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", null);
  }

}
