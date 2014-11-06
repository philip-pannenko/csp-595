package iit.csp595.bean;

import iit.csp595.domain.model.Product;

import java.io.Serializable;

public class ProductIndividualBean extends GenericIndividualPageBean<Product> implements Serializable {

  public ProductIndividualBean(Product bean) {
    super(bean, "pages/product-individual.jsp", null);
    super.setBrowserPageTitle("Product - " + bean.getName());
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Products", "product");
    super.getBreadcrumb().put(bean.getName(), null);
  }

}
