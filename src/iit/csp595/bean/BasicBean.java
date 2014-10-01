package iit.csp595.bean;

import java.io.Serializable;

public class BasicBean implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name = "hello";

  public BasicBean(String name) {
    super();
    this.name = name;
  }

  public BasicBean() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
