package iit.csp595;

import iit.csp595.domain.dao.UserDao;
import iit.csp595.domain.model.Cart;
import iit.csp595.domain.model.Order;
import iit.csp595.domain.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

public final class Utils {

  private static final String DELIM = ",";

  private Utils() {

  }

  public static int toInt(String s) {
    return toInt(s, -1);
  }

  public static int toInt(String s, int def) {
    try {
      return (s != null ? Integer.parseInt(s) : def);
    } catch (NumberFormatException e) {
      return -2;
    }
  }

  public static long toLong(String s) {
    return toLong(s, -1l);
  }

  public static long toLong(String s, long def) {
    try {
      return (s != null ? Long.parseLong(s) : def);
    } catch (NumberFormatException e) {
      return -2;
    }
  }

  public static long[] toLongArray(String s) {
    long[] result;
    if (s == null) {
      result = new long[] {-1L};
    } else {
      String[] split = s.split(DELIM);
      result = new long[split.length];
      for (int i = 0; i < split.length; i++) {
        result[i] = toLong(split[i]);
      }
    }
    return result;
  }

  public static void setAuthUser(HttpServletRequest request, User user) {
    HttpSession s = request.getSession();
    s.setAttribute("user", user);
  }

  public static User getAuthUser(HttpServletRequest request) {
    HttpSession s = request.getSession();
    Object o = s.getAttribute("user");
    if (o == null || o.getClass() != User.class) {
      return null;
    }
    return (User) s.getAttribute("user");
  }

  public static Cart getCart(HttpServletRequest request) {
    HttpSession s = request.getSession();
    Object o = s.getAttribute("cart");
    if (o == null) {
      s.setAttribute("cart", new Cart());
    }
    return (Cart) s.getAttribute("cart");
  }

  public static void clearCart(HttpServletRequest request) {
    HttpSession s = request.getSession();
    s.removeAttribute("cart");
  }

  public static String toString(Object o) {
    return (o != null ? o.toString() : null);
  }

  public static boolean isNullOrEmpty(String... inputs) {
    for (String input : inputs) {
      if (input == null || input.trim().isEmpty()) {
        return true;
      }
    }
    return false;
  }

  public static final void writeOrderToFile(Order order) {
    try (FileOutputStream fout = new FileOutputStream(Constants.IO_FILEPATH_ORDERS + "order_" + order.getId() + ".ser"); ObjectOutputStream oos = new ObjectOutputStream(fout);) {
      oos.writeObject(order);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static final Order readOrderFromFile(String name) {
    Order order = null;
    try (FileInputStream streamIn = new FileInputStream(Constants.IO_FILEPATH_ORDERS + name); ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);) {
      order = (Order) objectinputstream.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return order;
  }

  public static final void writeUserToFile(User user) {
    try (FileOutputStream fout = new FileOutputStream(Constants.IO_FILEPATH_USERS + "user_" + user.getId() + ".ser"); ObjectOutputStream oos = new ObjectOutputStream(fout);) {
      oos.writeObject(user);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static final void deleteUserFromFile(User user) {
    File f = new File(Constants.IO_FILEPATH_USERS + "user_" + user.getId() + ".ser");
    if (f.exists()) {
      f.delete();
    }
  }

  public static final User readUserFromFile(String name) {
    User user = null;
    try (FileInputStream streamIn = new FileInputStream(Constants.IO_FILEPATH_USERS + name); ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);) {
      user = (User) objectinputstream.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  public static final List<Order> readOrdersFromFile() {
    List<Order> result = new ArrayList<Order>();
    File folder = new File(Constants.IO_FILEPATH);
    if (!folder.exists()) {
      if (!folder.mkdir()) {
        System.err.println("Cannot create file " + folder.getAbsolutePath() + ", shutting down app");
        System.exit(0);
      }
    }
    folder = new File(Constants.IO_FILEPATH_ORDERS);
    if (!folder.exists()) {
      if (!folder.mkdir()) {
        System.err.println("Cannot create file " + folder.getAbsolutePath() + ", shutting down app");
        System.exit(0);
      }
    }
    for (final File file : folder.listFiles()) {
      if (file.isFile()) {
        Order order = readOrderFromFile(file.getName());
        if (order != null) {
          result.add(order);
        }
      }
    }
    return result;
  }

  public static final List<User> readUsersFromFile() {
    List<User> result = new ArrayList<User>();
    File folder = new File(Constants.IO_FILEPATH);
    if (!folder.exists()) {
      if (!folder.mkdir()) {
        System.err.println("Cannot create file " + folder.getAbsolutePath() + ", shutting down app");
        System.exit(0);
      }
    }
    folder = new File(Constants.IO_FILEPATH_USERS);
    if (!folder.exists()) {
      if (!folder.mkdir()) {
        System.err.println("Cannot create file " + folder.getAbsolutePath() + ", shutting down app");
        System.exit(0);
      }
    }
    for (final File file : folder.listFiles()) {
      if (file.isFile()) {
        User user = readUserFromFile(file.getName());
        if (user != null) {
          result.add(user);
        }
      }
    }
    return result;
  }

  public static String generateErrorMsg(String msg) throws UnsupportedEncodingException {
    return "error=" + URLEncoder.encode(msg, "UTF-8");
  }

  public static String generateErrorMsg(String msg, Object val) throws UnsupportedEncodingException {
    return "error=" + URLEncoder.encode(msg + ':' + val.toString(), "UTF-8");
  }

  public static String generateInfoMsg(String msg) throws UnsupportedEncodingException {
    return "info=" + URLEncoder.encode(msg, "UTF-8");
  }

  public static String generateInfoMsg(String msg, Object val) throws UnsupportedEncodingException {
    return "info=" + URLEncoder.encode(msg + ':' + val.toString(), "UTF-8");
  }

  public static boolean validateUserForm(User user) {

    if (user == null) {
      return false;
    }

    try {
      Map<String, String> result = BeanUtils.describe(user);

      if (result.get("lname") == null || result.get("lname").trim().isEmpty() || result.get("fname") == null || result.get("fname").trim().isEmpty()) {
        return false;
      }

      result = BeanUtils.describe(user.getBillingAddress());
      for (String key : result.keySet()) {
        if (result.get(key) == null || result.get(key).trim().isEmpty()) {
          return false;
        }
      }

      result = BeanUtils.describe(user.getShippingAddress());
      for (String key : result.keySet()) {
        if (result.get(key) == null || result.get(key).trim().isEmpty()) {
          return false;
        }
      }

      result = BeanUtils.describe(user.getPaymentMethod());
      for (String key : result.keySet()) {
        if (result.get(key) == null || result.get(key).trim().isEmpty()) {
          return false;
        }
      }
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static boolean validateUserAccount(User user) {
    if (user == null) {
      return false;
    }

    if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
      return false;
    }

    if (user.getPassword() == null || user.getPassword().toString().trim().isEmpty()) {
      return false;
    }

    UserDao dao = new UserDao();
    // If the user is new, double check that the username isn't used
    if (user.getId() == null && user.getUsername() != null && user.getUsername().trim().isEmpty() && dao.getUserByUsername(user.getUsername()) != null) {
      return false;
    }

    return true;
  }

  public static boolean validatePassword(User user, User authUser) {
    if (user == null || authUser == null || user.getPassword() == null || String.valueOf(user.getPassword()).trim().isEmpty()) {
      return false;
    }

    if (!Arrays.equals(user.getPassword(), authUser.getPassword())) {
      return false;
    }

    return true;
  }

  public static boolean isUsersEqual(User user, User user2) {

    boolean isUserEmpty = user == null || user.getId() == null || user.getId().longValue() == -1L;
    boolean isUserEmpty2 = user2 == null || user2.getId() == null || user2.getId().longValue() == -1L;

    if (isUserEmpty && isUserEmpty2) {
      return true;
    } else if (isUserEmpty && !isUserEmpty2 || !isUserEmpty && isUserEmpty2) {
      return false;
    } else if (user.getId().longValue() == user2.getId().longValue()) {
      return true;
    } else {
      return false;
    }
  }

}
