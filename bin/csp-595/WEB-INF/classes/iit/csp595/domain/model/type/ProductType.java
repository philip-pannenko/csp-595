package iit.csp595.domain.model.type;

public enum ProductType {
  NOT_APPLICABLE(-1, "N/A"),
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
