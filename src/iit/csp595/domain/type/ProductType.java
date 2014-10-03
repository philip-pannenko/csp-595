package iit.csp595.domain.type;

public enum ProductType {
  COFFEE(1, "Coffee"),
  ACCESSORY(2, "Accessory");

  private final int id;
  private final String name;

  ProductType(int id, String name) {
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
