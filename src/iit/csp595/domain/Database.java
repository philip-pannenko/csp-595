package iit.csp595.domain;

import iit.csp595.Utils;
import iit.csp595.domain.model.Accessory;
import iit.csp595.domain.model.Address;
import iit.csp595.domain.model.Category;
import iit.csp595.domain.model.Coffee;
import iit.csp595.domain.model.CreditCard;
import iit.csp595.domain.model.Order;
import iit.csp595.domain.model.Product;
import iit.csp595.domain.model.User;
import iit.csp595.domain.model.type.CategoryType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Database {

  // Concrete Tables
  public static final Map<Long, Category> CATEGORIES = initializeCategories(); // Needs to be initialized prior to products
  public static final Map<Long, Product> PRODUCTS = initializeProducts();
  public static final Map<Long, Coffee> COFFEES = initializeCoffeeProducts();
  public static final Map<Long, Accessory> ACCESSORIES = initializeAccessoryProducts();

  // Serialized Values to Disk
  public static final Map<Long, Order> ORDERS = loadOrders();
  public static final Map<Long, User> USERS = loadUsers();

  // Lookup Tables
  public static final Map<Long, List<Product>> CATEGORY_PRODUCT = mapCategory2Products();
  public static final Map<String, User> USERS_USERNAME = mapUsers2Username();
  public static final Map<Long, List<Order>> USER_ORDERS = mapUser2Orders();

  // Helper values pointers
  private static Category dd, sb, filter, grinder, african, local, blend, decaf;

  // Needs to be public for new additions
  public static long ORDER_SEQ_ID;
  public static long USER_SEQ_ID;

  private Database() {
  }

  private static Map<Long, Product> initializeProducts() {
    Map<Long, Product> result = new HashMap<Long, Product>();

    long productSeqId = -1l;

    result.put(++productSeqId, new Accessory(productSeqId, "Verve : Ethiopia Aricha", "some desc", 40.00D, grinder));
    result.put(++productSeqId, new Accessory(productSeqId, "Able Brewing: Kone Coffee Filter", "some desc", 60.00D, filter));

    result.put(++productSeqId, new Coffee(productSeqId, "Original Blend", "some desc", 8.99D, 16, dd, blend, local));
    result.put(++productSeqId, new Coffee(productSeqId, "Dunkin' Decaf", "some desc", 8.99D, 16, dd, decaf, african));
    result.put(++productSeqId, new Coffee(productSeqId, "French Vanilla", "some desc", 8.99D, 16, dd, blend, african));
    result.put(++productSeqId, new Coffee(productSeqId, "Dark Roast", "some desc", 8.99D, 16, dd, blend, local));

    result.put(++productSeqId, new Coffee(productSeqId, "Timor Mount Rameleau", "some desc", 11.99D, 10, sb, decaf, local));
    result.put(++productSeqId, new Coffee(productSeqId, "Guatemala Laguna de Ayarza", "some desc", 11.99D, 10, sb, blend, local));
    result.put(++productSeqId, new Coffee(productSeqId, "Starbucks® House Blend", "some desc", 11.95D, 16, sb, blend, african));
    result.put(++productSeqId, new Coffee(productSeqId, "Starbucks® Pike Place® Roast", "some desc", 11.95D, 16, sb, blend, local));

    return result;
  }

  private static Map<Long, Accessory> initializeAccessoryProducts() {
    Map<Long, Accessory> result = new HashMap<Long, Accessory>();

    for (Product p : PRODUCTS.values()) {
      if (p instanceof Accessory) {
        result.put(p.getId(), (Accessory) p);
      }
    }

    return result;

  }

  private static Map<Long, Coffee> initializeCoffeeProducts() {
    Map<Long, Coffee> result = new HashMap<Long, Coffee>();

    for (Product p : PRODUCTS.values()) {
      if (p instanceof Coffee) {
        result.put(p.getId(), (Coffee) p);
      }
    }

    return result;
  }

  private static Map<Long, Category> initializeCategories() {
    Map<Long, Category> result = new HashMap<Long, Category>();
    long categorySeqId = -1l;

    result.put(++categorySeqId, new Category(categorySeqId, "African", CategoryType.COFFEE_REGION));
    african = result.get(categorySeqId);
    result.put(++categorySeqId, new Category(categorySeqId, "Local", CategoryType.COFFEE_REGION));
    local = result.get(categorySeqId);

    result.put(++categorySeqId, new Category(categorySeqId, "Starbucks", CategoryType.COFFEE_STORE));
    sb = result.get(categorySeqId);
    result.put(++categorySeqId, new Category(categorySeqId, "Dunkin", CategoryType.COFFEE_STORE));
    dd = result.get(categorySeqId);

    result.put(++categorySeqId, new Category(categorySeqId, "Blend", CategoryType.COFFEE_BEAN_TYPE));
    blend = result.get(categorySeqId);
    result.put(++categorySeqId, new Category(categorySeqId, "Decaf", CategoryType.COFFEE_BEAN_TYPE));
    decaf = result.get(categorySeqId);

    result.put(++categorySeqId, new Category(categorySeqId, "Grinder", CategoryType.ACCESSORY_PURPOSE));
    grinder = result.get(categorySeqId);
    result.put(++categorySeqId, new Category(categorySeqId, "Filter", CategoryType.ACCESSORY_PURPOSE));
    filter = result.get(categorySeqId);

    return result;

  }

  private static Map<Long, User> loadUsers() {
    Map<Long, User> result = new HashMap<Long, User>();
    USER_SEQ_ID = -1l;

    Address shippingAddress;
    Address billingAddress;
    CreditCard paymentMethod;

    shippingAddress = new Address("1st Main St.", "Mystic", "06355", "CT");
    billingAddress = new Address("1st Main St.", "Mystic", "06355", "CT");
    paymentMethod = new CreditCard("1234123412341234", "Philip Pannenko", "01/20", "VISA");
    result.put(++USER_SEQ_ID, new User(USER_SEQ_ID, "Philip", "Pannenko", "ppannenk", "password".toCharArray(), billingAddress, shippingAddress, paymentMethod));

    shippingAddress = new Address("1st Main St.", "Chicago", "60616", "IL");
    billingAddress = new Address("1st Main St.", "Chicago", "60616", "IL");
    paymentMethod = new CreditCard("1234123412341234", "Zaharadeen Garuba", "01/20", "VISA");
    result.put(++USER_SEQ_ID, new User(USER_SEQ_ID, "Zaharadeen", "Garuba", "zgaruba", "password".toCharArray(), billingAddress, shippingAddress, paymentMethod));

    shippingAddress = new Address("1st Main St.", "Chicago", "60616", "IL");
    billingAddress = new Address("1st Main St.", "Chicago", "60616", "IL");
    paymentMethod = new CreditCard("1234123412341234", "James Murnane", "01/20", "VISA");
    result.put(++USER_SEQ_ID, new User(USER_SEQ_ID, "James", "Murnane", "jmurnane", "password".toCharArray(), billingAddress, shippingAddress, paymentMethod));

    return result;
  }

  private static Map<Long, Order> loadOrders() {
    ORDER_SEQ_ID = -1l;
    List<Order> orders = Utils.readOrdersFromFile();
    if (orders != null && !orders.isEmpty()) {
      Map<Long, Order> result = new HashMap<Long, Order>();
      for (Order order : orders) {
        result.put(order.getId(), order);
        if (order.getId() > ORDER_SEQ_ID) {
          ORDER_SEQ_ID = order.getId();
        }
      }
      return result;
    } else {
      Map<Long, Order> result = new HashMap<Long, Order>();
      return result;
    }
  }

  private static Map<String, User> mapUsers2Username() {
    Map<String, User> result = new HashMap<String, User>();
    for (User u : USERS.values()) {
      result.put(u.getUsername(), u);
    }
    return result;
  }

  private static Map<Long, List<Product>> mapCategory2Products() {
    Map<Long, List<Product>> result = new HashMap<Long, List<Product>>();

    // There is a unique pair between product and category
    // As a result, let's find which products are associated
    // to which category so that we can perform a filter on them
    for (Product p : PRODUCTS.values()) {
      for (Category c : p.getCategories()) {
        Long id = c.getId();
        if (!result.containsKey(id)) {
          result.put(id, new ArrayList<Product>());
        }
        result.get(id).add(p);
      }
    }
    return result;
  }

  private static Map<Long, List<Order>> mapUser2Orders() {
    if (ORDERS != null && !ORDERS.isEmpty()) {
      Map<Long, List<Order>> result = new HashMap<Long, List<Order>>();
      for (Order order : ORDERS.values()) {
        Long id = order.getUser().getId();
        if (!result.containsKey(id)) {
          result.put(id, new ArrayList<Order>());
        }
        result.get(id).add(order);
      }
      return result;
    } else {
      return new HashMap<Long, List<Order>>();
    }
  }

}
