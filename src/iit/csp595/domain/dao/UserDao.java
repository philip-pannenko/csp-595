package iit.csp595.domain.dao;

import java.util.Arrays;
import java.util.Collection;

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

}
