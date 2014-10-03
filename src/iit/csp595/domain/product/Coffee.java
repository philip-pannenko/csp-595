package iit.csp595.domain.product;

import iit.csp595.domain.Category;
import iit.csp595.domain.Tag;
import iit.csp595.domain.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Coffee extends Product implements Serializable {

  private static final long serialVersionUID = 1L;
  private List<Tag> flavors;
  private Integer ounces;

  // private Category coffeeType;
  // private Category store;
  // private Category region;

  public Coffee(Long id, String name, String description, Double price, Integer ounces, Category... categories) {
    super(id, name, description, price, Arrays.asList(categories));
    this.ounces = ounces;
  }

  public List<Tag> getFlavors() {
    return flavors;
  }

  public void setFlavors(List<Tag> flavors) {
    this.flavors = flavors;
  }

  public Integer getOunces() {
    return ounces;
  }

  public void setOunces(Integer ounces) {
    this.ounces = ounces;
  }

}
