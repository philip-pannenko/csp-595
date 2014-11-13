package iit.csp595.bean;

import iit.csp595.Utils;
import iit.csp595.domain.dao.ProductDao;
import iit.csp595.domain.model.Order;
import iit.csp595.domain.model.Product;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderIndividualBean extends GenericIndividualPageBean<Order> implements Serializable {

  private Map<Long, Product> products = new HashMap<Long, Product>();

  public OrderIndividualBean(Order bean) {
    super(bean, "pages/order-individual.jsp", null);
    super.setBrowserPageTitle("Order - " + bean.getId());
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Account", "account");
    super.getBreadcrumb().put("Order", "account/order");
    super.getBreadcrumb().put("Order " + bean.getId(), null);

    loadProducts(bean);
  }

  private void loadProducts(Order bean) {

    Map<Long, Integer> products = bean.getProducts();
    ProductDao dao = new ProductDao();
    for (Long p : products.keySet()) {
      Product product = dao.get(p);
      this.products.put(product.getId(), product);
    }
  }

  public Map<Long, Product> getProducts() {
    return products;
  }

  public void setProducts(Map<Long, Product> products) {
    this.products = products;
  }

  public boolean isOrderCancelable() {
    return Utils.isOrderCancelable(getItem().getDeliveryDate());
  }
}
