package iit.csp595.bean.product;

import java.io.Serializable;
import java.util.List;
import java.util.TreeMap;

import iit.csp595.bean.GenericListingPageBean;
import iit.csp595.domain.Product;

public class ProductListingBean extends GenericListingPageBean<Product> implements Serializable {

  private static final long serialVersionUID = 1L;

  public ProductListingBean(List<Product> products, int totalProducts) {
    super(products, totalProducts, "pages/product-listing.jsp");
    this.browserPageTitle = "Product Listing";
    this.breadcrumb = new TreeMap<String, String>();
    this.breadcrumb.put("Home", "");
    this.breadcrumb.put("Products", null);
  }

}
