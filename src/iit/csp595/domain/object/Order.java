package iit.csp595.domain.object;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {

  private Long id;
  private String description;
  private Date orderDate;
  private BigDecimal totalPrice;
  private List<Product> products;

  public Order(Long id, String description, Date orderDate, BigDecimal totalPrice, List<Product> products) {
    super();
    this.id = id;
    this.description = description;
    this.orderDate = orderDate;
    this.totalPrice = totalPrice;
    this.products = products;
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

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

}
