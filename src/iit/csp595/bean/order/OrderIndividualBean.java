package iit.csp595.bean.order;

import iit.csp595.bean.GenericIndividualPageBean;
import iit.csp595.domain.model.Order;

import java.io.Serializable;

public class OrderIndividualBean extends GenericIndividualPageBean<Order> implements Serializable {

  public OrderIndividualBean(Order bean) {
    super(bean, "pages/account/order-individual.jsp", null);
    super.setBrowserPageTitle("Order - " + bean.getId());
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", "account");
    super.getBreadcrumb().put("Order " + bean.getId(), null);
  }

}
