package iit.csp595.domain.type;

public enum SortType {
  PRICE_ASC(1, "Price Ascending"),
  PRICE_DESC(2, "Price Descending"),
  SIZE_ASC(3, "Size (oz) Ascending"),
  SIZE_DESC(4, "Size (oz) Descending"),
  NAME_ASC(5, "Name Ascending"),
  NAME_DESC(6, "Name Descending");

  private final int id;
  private final String name;

  SortType(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
