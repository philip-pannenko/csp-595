package iit.csp595.bean;

import java.io.Serializable;

public abstract class GenericIndividualPageBean<T> extends GenericPageBean<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private T item;

  protected GenericIndividualPageBean(T item, String pageFileName, Message message) {
    super(pageFileName, message);
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }

}
