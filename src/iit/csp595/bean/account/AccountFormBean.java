package iit.csp595.bean.account;

import iit.csp595.bean.GenericFormPageBean;
import iit.csp595.domain.model.User;

import java.io.Serializable;

public class AccountFormBean extends GenericFormPageBean<User> implements Serializable {

  public AccountFormBean(User bean) {
    super("pages/settings-form.jsp", bean);
    super.setBrowserPageTitle("Settings Page");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", "account");
    super.getBreadcrumb().put("Settings", null);
  }

}
