package iit.csp595.bean.account;

import iit.csp595.bean.GenericFormPageBean;
import iit.csp595.domain.model.User;

import java.io.Serializable;

public class AccountIndividualBean extends GenericFormPageBean<User> implements Serializable {

  public AccountIndividualBean(User bean) {
    super("pages/account-page.jsp", bean);
    super.setBrowserPageTitle("Account Page");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", null);
  }

}
