package iit.csp595.bean.account;

import java.io.Serializable;
import java.util.List;

import iit.csp595.bean.GenericListingPageBean;
import iit.csp595.domain.object.Order;
import iit.csp595.domain.object.type.CategoryType;

public class OrderListingBean extends GenericListingPageBean<Order> implements Serializable {

  private static final long serialVersionUID = 1L;

  public OrderListingBean(List<Order> products, int totalProducts) {
    super(products, null, totalProducts, "pages/account/order-listing.jsp");
    super.setBrowserPageTitle("Account - Orders");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", "account");
    super.getBreadcrumb().put("Orders", null);
  }

}
