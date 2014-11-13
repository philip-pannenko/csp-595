package iit.csp595.domain.dao;

import java.util.Arrays;
import java.util.Collection;

import iit.csp595.Utils;
import iit.csp595.domain.Database;
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

}
