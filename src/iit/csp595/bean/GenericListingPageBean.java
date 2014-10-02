package iit.csp595.bean;

import java.io.Serializable;
import java.util.List;

public abstract class GenericListingPageBean<T> extends GenericPageBean<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<T> items;
  private int currentPage = 1;
  private int totalPages = 0;
  private int itemsPerPage = 2;

  protected GenericListingPageBean(List<T> items, int totalItems, String pageFileName) {
   super(pageFileName);
    this.items = items;
    this.totalPages = (int) Math.ceil(totalItems / itemsPerPage);
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }

  public int getItemsPerPage() {
    return itemsPerPage;
  }

  public void setItemsPerPage(int itemsPerPage) {
    this.itemsPerPage = itemsPerPage;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

}
