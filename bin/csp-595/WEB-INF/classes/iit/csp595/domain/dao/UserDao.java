package iit.csp595.domain.dao;

import java.util.Arrays;
import java.util.Collection;

import iit.csp595.Utils;
import iit.csp595.domain.Database;
import iit.csp595.domain.model.Address;
import iit.csp595.domain.model.CreditCard;
import iit.csp595.domain.model.User;

public class UserDao {

  public User get(Long id) {
    return Database.USERS.get(id);
  }

  public Collection<User> get() {
    return Database.USERS.values();
  }

  public User login(String username, char[] password) {
    User user = Database.USERS_USERNAME.get(username);
    return (user != null && Arrays.equals(password, user.getPassword())) ? user : null;
  }

  public User getUserByUsername(String username) {
    User user = Database.USERS_USERNAME.get(username);
    return user;
  }

  public void deleteUser(User user) {
    Database.USERS.remove(user.getId());
    Database.USERS_USERNAME.remove(user.getUsername());
    Utils.deleteUserFromFile(user);
  }

  public void saveUser(User user) {
    Database.USERS.put(user.getId(), user);
    Database.USERS_USERNAME.put(user.getUsername(), user);
    Utils.writeUserToFile(user);
  }
  
  /**
   * Call this method to initalize the DB with some user login information
   */
  public void loadUsers() {
    Address shippingAddress;
    Address billingAddress;
    CreditCard paymentMethod;
    User user;
    
    shippingAddress = new Address("1st Main St.", "Mystic", "06355", "CT");
    billingAddress = new Address("1st Main St.", "Mystic", "06355", "CT");
    paymentMethod = new CreditCard("1234123412341234", "Philip Pannenko", "01/20", "VISA");
    user = new User(++Database.USER_SEQ_ID, "Philip", "Pannenko", "ppannenk", "password".toCharArray(), billingAddress, shippingAddress, paymentMethod);

    saveUser(user);
    
    shippingAddress = new Address("1st Main St.", "Chicago", "60616", "IL");
    billingAddress = new Address("1st Main St.", "Chicago", "60616", "IL");
    paymentMethod = new CreditCard("1234123412341234", "Zaharadeen Garuba", "01/20", "VISA");
    user = new User(++Database.USER_SEQ_ID, "Zaharadeen", "Garuba", "zgaruba", "password".toCharArray(), billingAddress, shippingAddress, paymentMethod);

    saveUser(user);
    
    shippingAddress = new Address("1st Main St.", "Chicago", "60616", "IL");
    billingAddress = new Address("1st Main St.", "Chicago", "60616", "IL");
    paymentMethod = new CreditCard("1234123412341234", "James Murnane", "01/20", "VISA");
    user = new User(++Database.USER_SEQ_ID, "James", "Murnane", "jmurnane", "password".toCharArray(), billingAddress, shippingAddress, paymentMethod);

    saveUser(user);
    
  }

}
