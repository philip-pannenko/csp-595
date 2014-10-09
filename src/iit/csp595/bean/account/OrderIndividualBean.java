package iit.csp595.bean.account;

import iit.csp595.bean.GenericIndividualPageBean;
import iit.csp595.domain.object.Order;

import java.io.Serializable;

public class OrderIndividualBean extends GenericIndividualPageBean<Order> implements Serializable {

  private static final long serialVersionUID = 1L;

  public OrderIndividualBean(Order bean) {
    super(bean, "pages/account/order-individual.jsp", null);
    super.setBrowserPageTitle("Order - " + bean.getId());
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", "account");
    super.getBreadcrumb().put("Order " + bean.getId(), null);
  }

}
