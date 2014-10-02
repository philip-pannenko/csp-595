package iit.csp595.bean.product;

import java.io.Serializable;
import java.util.TreeMap;

import iit.csp595.bean.GenericIndividualPageBean;
import iit.csp595.domain.Product;

public class ProductIndividualBean extends GenericIndividualPageBean<Product> implements Serializable {

  private static final long serialVersionUID = 1L;

  public ProductIndividualBean(Product bean) {
    super(bean, "pages/product-individual.jsp", null);
    this.browserPageTitle = "Product - " + bean.getName();
    this.breadcrumb = new TreeMap<String, String>();
    this.breadcrumb.put("Home", "");
    this.breadcrumb.put("Products", "product");
    this.breadcrumb.put(bean.getName(), null);
  }

}
