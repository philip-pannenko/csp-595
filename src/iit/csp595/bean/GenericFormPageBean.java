package iit.csp595.bean;

import java.io.Serializable;

public abstract class GenericFormPageBean<T> extends GenericPageBean<T> implements Serializable {

  private T item;

  protected GenericFormPageBean(String pageFileName, T item) {
    super(pageFileName);
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }

}
