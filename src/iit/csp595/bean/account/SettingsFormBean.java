package iit.csp595.bean.account;

import iit.csp595.bean.GenericFormPageBean;
import iit.csp595.domain.object.User;

import java.io.Serializable;

public class SettingsFormBean extends GenericFormPageBean<User> implements Serializable {

  private static final long serialVersionUID = 1L;

  public SettingsFormBean(User bean) {
    super("pages/account/settings-form.jsp", bean);
    super.setBrowserPageTitle("Settings Page");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", "account");
    super.getBreadcrumb().put("Settings", null);
  }

}
