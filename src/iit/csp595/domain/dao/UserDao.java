package iit.csp595.domain.dao;

import java.util.Arrays;
import java.util.Collection;

import iit.csp595.domain.object.User;

public class UserDao {

  public User get(Long id) {
    return TempDB.USERS.get(id);
  }

  public Collection<User> get() {
    return TempDB.USERS.values();
  }

  public User login(String username, char[] password) {
    User user = TempDB.USERS_USERNAME.get(username);
    return (user != null && Arrays.equals(password, user.getPassword())) ? user : null;
  }

}
