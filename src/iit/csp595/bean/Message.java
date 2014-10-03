package iit.csp595.bean;

import java.io.Serializable;

public class Message implements Serializable {

  private static final long serialVersionUID = 1L;
  private String type;
  private String content;

  public Message(String type, String content) {
    super();
    this.type = type;
    this.content = content;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
