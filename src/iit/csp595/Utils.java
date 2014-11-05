package iit.csp595;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import iit.csp595.domain.model.Cart;
import iit.csp595.domain.model.Order;
import iit.csp595.domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class Utils {

  private static final String DELIM = ",";

  private Utils() {

  }

  // public static int toInt(String s) {
  // return toInt(s, -1);
  // }

  public static int toInt(String s) {
    try {
      return (s != null ? Integer.parseInt(s) : -1);
    } catch (NumberFormatException e) {
      return -2;
    }
  }

  public static long toLong(String s) {
    try {
      return (s != null ? Long.parseLong(s) : -1);
    } catch (NumberFormatException e) {
      return -2;
    }
  }

  public static long[] toLongArray(String s) {
    long[] result;
    if (s == null) {
      result = new long[] { -1L };
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
    try (
        FileOutputStream fout = new FileOutputStream(Constants.IO_FILEPATH_ORDERS + "order_" + order.getId() + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);) {
      oos.writeObject(order);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static final Order readOrderFromFile(String name) {
    Order order = null;
    try (
        FileInputStream streamIn = new FileInputStream(Constants.IO_FILEPATH_ORDERS + name);
        ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);) {
      order = (Order) objectinputstream.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return order;
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

  public static String showMessage(String msg) throws UnsupportedEncodingException {
    return URLEncoder.encode(Constants.ERROR_ORDER_NOT_FOUND, "UTF-8");
  }

  public static String showMessage(String msg, Object val) throws UnsupportedEncodingException {
    return URLEncoder.encode(msg + ':' + val.toString(), "UTF-8");
  }

}
