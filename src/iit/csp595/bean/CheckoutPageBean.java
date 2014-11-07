package iit.csp595.bean;

import iit.csp595.domain.model.User;

import java.io.Serializable;

public class CheckoutPageBean extends GenericIndividualPageBean<User> implements Serializable {

  public CheckoutPageBean(User item) {
    super(item, "pages/checkout-page.jsp", null);
    super.setBrowserPageTitle("Checkout");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Cart", "cart");
    super.getBreadcrumb().put("Checkout", null);
  }
}
