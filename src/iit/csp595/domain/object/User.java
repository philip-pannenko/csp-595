package iit.csp595.domain.object;

import java.io.Serializable;

public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String fname;
  private String lname;
  private String username;
  private char[] password;

  public User() {
    super();
  }

  public User(Long id, String fname, String lname, String username, char[] password) {
    super();
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.username = username;
    this.password = password;
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

}
