package iit.csp595.domain.model;

import java.io.Serializable;

public class CreditCard implements Serializable {

  private String number;
  private String name;
  private String expirationDate;
  private String type = "VISA";

  public CreditCard() {
  }

  public CreditCard(String number, String name, String expirationDate, String type) {
    this.number = number;
    this.name = name;
    this.expirationDate = expirationDate;
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
