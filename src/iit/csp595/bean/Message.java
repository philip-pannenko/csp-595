package iit.csp595.bean;

import java.io.Serializable;

public class Message implements Serializable {

  private boolean error = false;
  private String content;

  public Message(boolean error, String content) {
    super();
    this.error = error;
    this.content = content;
  }

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public String getContent() {
    return content;
  } 

  public void setContent(String content) {
    this.content = content;
  }

}
