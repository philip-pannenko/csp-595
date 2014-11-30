package iit.csp595.bean;

import java.io.Serializable;

/**
 * Used as a guideline for form based pages of a certain type
 */
public abstract class GenericFormPageBean<T> extends GenericPageBean implements Serializable {

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
