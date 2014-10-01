package iit.csp595.bean;

import iit.csp595.domain.Message;

import java.io.Serializable;
import java.util.List;

public abstract class GenericListingPageBean<T> extends GenericPageBean<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<T> items;

  /**
   * Created to force the compile to remind us to need a bean for these pages
   * 
   * @param bean
   */
  protected GenericListingPageBean(List<T> items, String pageFileName, Message message) {
    super(pageFileName, message);
    this.items = items;
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }

}
