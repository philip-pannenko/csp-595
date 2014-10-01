package iit.csp595.bean;

import iit.csp595.domain.Message;

import java.io.Serializable;

public abstract class GenericIndividualPageBean<T> extends GenericPageBean<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private T item;

  /**
   * Created to force the compile to remind us to need a bean for these pages
   * 
   * @param bean
   */
  
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
