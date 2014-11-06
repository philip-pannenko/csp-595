package iit.csp595;

public enum SortType {
  NOT_APPLICABLE(-1, "N/A"),
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

  public static SortType getSortTypeFromId(int id) {
    if (id == 1) {
      return PRICE_ASC;
    } else if (id == 2) {
      return PRICE_DESC;
    } else if (id == 3) {
      return SIZE_ASC;
    } else if (id == 4) {
      return SIZE_DESC;
    } else if (id == 5) {
      return NAME_ASC;
    } else if (id == 6) {
      return NAME_DESC;
    } else {
      return NOT_APPLICABLE;
    }
  }
}
