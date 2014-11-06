package iit.csp595.bean;

import iit.csp595.domain.model.Cart;

import java.io.Serializable;

public class CheckoutPageBean extends GenericPageBean implements Serializable {

  public CheckoutPageBean(Cart bean) {
    super("pages/checkout-page.jsp");
    super.setBrowserPageTitle("Checkout");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Cart", "cart");
    super.getBreadcrumb().put("Checkout", null);

  }

}
