package iit.csp595.domain.object.product;

import iit.csp595.domain.object.Category;
import iit.csp595.domain.object.Product;

import java.io.Serializable;
import java.util.Arrays;

public class Accessory extends Product implements Serializable {

  // private Category purpose;

  public Accessory(Long id, String name, String description, Double price, Category... categories) {
    super(id, name, description, price, Arrays.asList(categories));
  }

}
