package iit.csp595.bean.product;

import java.io.Serializable;

import iit.csp595.bean.GenericIndividualPageBean;
import iit.csp595.domain.object.Product;

public class ProductIndividualBean extends GenericIndividualPageBean<Product> implements Serializable {

  private static final long serialVersionUID = 1L;

  public ProductIndividualBean(Product bean) {
    super(bean, "pages/product-individual.jsp", null);
    super.setBrowserPageTitle("Product - " + bean.getName());
    super.getBreadcrumb().put("Home", "");
    super.getBreadcrumb().put("Products", "product");
    super.getBreadcrumb().put(bean.getName(), null);
  }

}
