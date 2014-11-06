package iit.csp595.bean;

import iit.csp595.domain.dao.ProductDao;
import iit.csp595.domain.model.Cart;
import iit.csp595.domain.model.Product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CartIndividualBean extends GenericIndividualPageBean<Cart> implements Serializable {

  private Map<Long, Product> products = new HashMap<Long, Product>();

  public CartIndividualBean(Cart bean) {
    super(bean, "pages/cart-individual.jsp", null);
    super.setBrowserPageTitle("Cart");
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Cart", null);

    calculateTotals(bean);

  }

  private void calculateTotals(Cart cart) {
    double totalCost = 0D;
    int totalProducts = 0;
    Map<Long, Integer> products = cart.getProducts();
    ProductDao dao = new ProductDao();
    for (Long p : products.keySet()) {

      int count = products.get(p);
      totalProducts += count;

      Product product = dao.get(p);

      double productCountCost = product.getPrice();
      productCountCost *= count;

      totalCost += productCountCost;

      this.products.put(product.getId(), product);

    }

    cart.setTotalCost(totalCost);
    cart.setTotalProducts(totalProducts);

  }

  public Map<Long, Product> getProducts() {
    return products;
  }

  public void setProducts(Map<Long, Product> products) {
    this.products = products;
  }

}
