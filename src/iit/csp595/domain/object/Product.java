package iit.csp595.domain.object;

import java.io.Serializable;
import java.util.List;

public abstract class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String imageName;
  private String name;
  private String description;
  private Double price;
  private List<Category> categories;
  private List<Tag> tags;

  public Product(Long id, String name, String description, Double price, List<Category> categories) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.categories = categories;
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
  }

}
