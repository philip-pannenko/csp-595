package iit.csp595.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {

  private Long id;
  private String description;
  private Date orderDate;
  private Double totalPrice;
  private Map<Long, Integer> products = new HashMap<Long, Integer>();
  private User user;
  private Boolean active = true;
  private Date deliveryDate;

  public Order() {
  }

  public Order(Long id, String description, Date orderDate, Date deliveryDate, Double totalPrice, Map<Long, Integer> products, User user) {
    this.id = id;
    this.description = description;
    this.orderDate = orderDate;
    this.deliveryDate = deliveryDate;
    this.totalPrice = totalPrice;
    this.products = products;
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
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

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

}
