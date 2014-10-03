package iit.csp595.domain;

import java.io.Serializable;

public class Tag implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private String description;

  public Tag(Long id, String description) {
    super();
    this.id = id;
    this.description = description;
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

}
