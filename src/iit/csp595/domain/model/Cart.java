package iit.csp595.domain.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {

  private Long id;
  private User user;
  private Map<Long, Integer> products = new HashMap<Long, Integer>();
  private Double totalCost;
  private Integer totalProducts;

  public Cart() {
  }

  public Cart(Long id, Map<Long, Integer> products, User user) {
    this.products = products;
    this.user = user;
  }

  public Map<Long, Integer> getProducts() {
    return products;
  }

  public void setProducts(Map<Long, Integer> products) {
    this.products = products;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }

  public Integer getTotalProducts() {
    return totalProducts;
  }

  public void setTotalProducts(Integer totalProducts) {
    this.totalProducts = totalProducts;
  }

}
