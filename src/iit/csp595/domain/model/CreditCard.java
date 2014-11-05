package iit.csp595.domain.model;

import java.util.Date;

public class CreditCard {
  private Integer number;
  private String name;
  private Date expirationDate;
  private String type = "VISA";

  public CreditCard() {
  }

  public CreditCard(Integer number, String name, Date expirationDate, String type) {
    this.number = number;
    this.name = name;
    this.expirationDate = expirationDate;
    this.type = type;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
