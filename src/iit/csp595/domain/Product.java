package iit.csp595.domain;

import java.io.Serializable;

public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String description;
  private String genre;
  private Double price;

  public Product(Long id, String name, String description, String genre, Double price) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
    this.genre = genre;
    this.price = price;
  }

  public Product() {
    super();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}
