package iit.csp595.bean;

import iit.csp595.domain.object.type.CategoryType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericListingPageBean<T> extends GenericPageBean<T> implements Serializable {

  private List<T> items;
  private List<CategoryType> categoryTypes = new ArrayList<CategoryType>();
  private int currentPage = 1;
  private long[] currentCategories = {-1L};
  private int totalPages = 0;
  private int itemsPerPage = 2;

  protected GenericListingPageBean(List<T> items, List<CategoryType> categoryTypes, int totalItems, String pageFileName) {
    super(pageFileName);
    this.items = items;
    this.categoryTypes = categoryTypes;
    this.totalPages = (int) Math.ceil(totalItems / itemsPerPage);
  }

  public String getParsedCurrentCategories() {
    return format(currentCategories);
  }

  public static String format(long[] tokens) {
    char delimiter = ',';
    if (tokens == null) {
      return "-1";
    }
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < tokens.length; i++) {
      if (i > 0) {
        result.append(delimiter);
      }
      result.append(String.valueOf(tokens[i]));
    }
    return result.toString();
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

  public List<CategoryType> getCategoryTypes() {
    return categoryTypes;
  }

  public void setCategoryTypes(List<CategoryType> categoryTypes) {
    this.categoryTypes = categoryTypes;
  }

  public long[] getCurrentCategories() {
    return currentCategories;
  }

  public void setCurrentCategories(long[] currentCategory) {
    this.currentCategories = currentCategory;
  }

}
