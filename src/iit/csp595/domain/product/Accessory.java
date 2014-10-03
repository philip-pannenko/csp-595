package iit.csp595.domain.product;

import iit.csp595.domain.Category;
import iit.csp595.domain.Product;

import java.io.Serializable;
import java.util.Arrays;

public class Accessory extends Product implements Serializable {

  private static final long serialVersionUID = 1L;

  // private Category purpose;

  public Accessory(Long id, String name, String description, Double price, Category... categories) {
    super(id, name, description, price, Arrays.asList(categories));
  }

}
