package iit.csp595.domain;

public enum CategoryType {
  COFFEE_STORE(1, "Store"),
  COFFEE_REGION(2, "Region"),
  COFFEE_BEAN_TYPE(3, "Bean Type"),
  ACCESSORY_PURPOSE(4, "Purpose");

  private final int id;
  private final String name;

  CategoryType(int id, String name) {
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
