package iit.csp595.bean;

import iit.csp595.domain.model.User;

import java.io.Serializable;

public class SettingFormBean extends GenericFormPageBean<User> implements Serializable {

  public SettingFormBean(User bean) {
    super("pages/setting-form.jsp", bean);
    super.setBrowserPageTitle("Settings Page");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", "account");
    super.getBreadcrumb().put("Settings", null);
  }

}
