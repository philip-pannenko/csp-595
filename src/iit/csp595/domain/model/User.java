package iit.csp595.domain.model;

import java.io.Serializable;

public class User implements Serializable {

  private Long id;
  private String fname;
  private String lname;
  private String username;
  private char[] password;

  private Address billingAddress;
  private Address shippingAddress;
  private CreditCard paymentMethod;

  public User() {
  }

  public User(Long id, String fname, String lname, String username, char[] password, Address billingAddress, Address shippingAddress, CreditCard paymentMethod) {
    super();
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.username = username;
    this.password = password;
    this.billingAddress = billingAddress;
    this.shippingAddress = shippingAddress;
    this.paymentMethod = paymentMethod;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public char[] getPassword() {
    return password;
  }

  public void setPassword(char[] password) {
    this.password = password;
  }

  public Address getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(Address billingAddress) {
    this.billingAddress = billingAddress;
  }

  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public CreditCard getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(CreditCard paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

}
