package iit.csp595.bean;

import java.io.Serializable;

/**
 * Used as a guideline for pages that will use a certain type of bean
 */
public abstract class GenericIndividualPageBean<T> extends GenericPageBean implements Serializable {

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
