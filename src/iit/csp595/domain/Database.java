package iit.csp595.domain;

//import homework.Utils;
import iit.csp595.Utils;
import iit.csp595.domain.model.Category;
import iit.csp595.domain.model.Order;
import iit.csp595.domain.model.Product;
import iit.csp595.domain.model.User;
import iit.csp595.domain.model.product.Accessory;
import iit.csp595.domain.model.product.Coffee;
import iit.csp595.domain.model.type.CategoryType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public final class Database {

  public static final SortedMap<Long, Product> PRODUCTS = new TreeMap<Long, Product>();
  public static final SortedMap<Long, Order> ORDERS = new TreeMap<Long, Order>();
  public static final SortedMap<Long, User> USERS = new TreeMap<Long, User>();
  public static final SortedMap<Long, Category> CATEGORIES = new TreeMap<Long, Category>();
  public static final SortedMap<Long, Coffee> COFFEES = new TreeMap<Long, Coffee>();
  public static final SortedMap<Long, Accessory> ACCESSORIES = new TreeMap<Long, Accessory>();
  public static final SortedMap<Long, List<Product>> CATEGORY_PRODUCT = new TreeMap<Long, List<Product>>();
  public static final SortedMap<String, User> USERS_USERNAME = new TreeMap<String, User>();

  private static Category dd, sb, filter, grinder, african, local, blend, decaf;

  // Used as a sequence helper
  private static Long dbId;
  public static long ORDER_SEQ_ID;

  private Database() {

  }

  public static void initDB() {
    System.out.println("initDB");

    initiateCategories();
    initiateUsers();
    initiateProducts();
    initiateOrders();

  }

  private static void initiateCategories() {

    resetSeq();
    CATEGORIES.clear();
    CATEGORIES.put(nextSeq(), new Category(getSeq(), "African", CategoryType.COFFEE_REGION));
    african = CATEGORIES.get(getSeq());
    CATEGORIES.put(nextSeq(), new Category(getSeq(), "Local", CategoryType.COFFEE_REGION));
    local = CATEGORIES.get(getSeq());

    CATEGORIES.put(nextSeq(), new Category(getSeq(), "Starbucks", CategoryType.COFFEE_STORE));
    sb = CATEGORIES.get(getSeq());
    CATEGORIES.put(nextSeq(), new Category(getSeq(), "Dunkin", CategoryType.COFFEE_STORE));
    dd = CATEGORIES.get(getSeq());

    CATEGORIES.put(nextSeq(), new Category(getSeq(), "Blend", CategoryType.COFFEE_BEAN_TYPE));
    blend = CATEGORIES.get(getSeq());
    CATEGORIES.put(nextSeq(), new Category(getSeq(), "Decaf", CategoryType.COFFEE_BEAN_TYPE));
    decaf = CATEGORIES.get(getSeq());

    CATEGORIES.put(nextSeq(), new Category(getSeq(), "Grinder", CategoryType.ACCESSORY_PURPOSE));
    grinder = CATEGORIES.get(getSeq());
    CATEGORIES.put(nextSeq(), new Category(getSeq(), "Filter", CategoryType.ACCESSORY_PURPOSE));
    filter = CATEGORIES.get(getSeq());

  }

  private static void initiateUsers() {

    resetSeq();
    USERS.clear();
    USERS.put(nextSeq(), new User(getSeq(), "Philip", "Pannenko", "ppannenk", "password".toCharArray()));
    USERS.put(nextSeq(), new User(getSeq(), "Zaharadeen", "Garuba", "zgaruba", "password".toCharArray()));
    USERS.put(nextSeq(), new User(getSeq(), "James", "Murnane", "jmurnane", "password".toCharArray()));

    for (User u : USERS.values()) {
      USERS_USERNAME.put(u.getUsername(), u);
    }
  }

  private static void initiateProducts() {

    resetSeq();
    COFFEES.clear();
    ACCESSORIES.clear();
    PRODUCTS.clear();

    // Dunkin Donuts
    // Original Blend 8.99 16oz
    // Dunkin' Decaf 8.99 16oz
    // French Vanilla 8.99 16oz
    // Dark Roast 8.99 16oz
    COFFEES.put(nextSeq(), new Coffee(getSeq(), "Original Blend", "some desc", 8.99D, 16, dd, blend, local));
    COFFEES.put(nextSeq(), new Coffee(getSeq(), "Dunkin' Decaf", "some desc", 8.99D, 16, dd, decaf, african));
    COFFEES.put(nextSeq(), new Coffee(getSeq(), "French Vanilla", "some desc", 8.99D, 16, dd, blend, african));
    COFFEES.put(nextSeq(), new Coffee(getSeq(), "Dark Roast", "some desc", 8.99D, 16, dd, blend, local));

    // Starbucks
    // Timor Mount Rameleau 11.99 10oz
    // Guatemala Laguna de Ayarza 11.99 10oz
    // Starbucks� House Blend 11.95 16oz
    // Starbucks� Pike Place� Roast, Ground 11.95 16oz
    COFFEES.put(nextSeq(), new Coffee(getSeq(), "Timor Mount Rameleau", "some desc", 11.99D, 10, sb, decaf, local));
    COFFEES.put(nextSeq(), new Coffee(getSeq(), "Guatemala Laguna de Ayarza", "some desc", 11.99D, 10, sb, blend, local));
    COFFEES.put(nextSeq(), new Coffee(getSeq(), "Starbucks� House Blend", "some desc", 11.95D, 16, sb, blend, african));
    COFFEES.put(nextSeq(), new Coffee(getSeq(), "Starbucks� Pike Place� Roast", "some desc", 11.95D, 16, sb, blend, local));

    ACCESSORIES.put(nextSeq(), new Accessory(getSeq(), "Verve : Ethiopia Aricha", "some desc", 40.00D, grinder));
    ACCESSORIES.put(nextSeq(), new Accessory(getSeq(), "Able Brewing: Kone Coffee Filter", "some desc", 60.00D, filter));

    for (Coffee p : COFFEES.values()) {
      PRODUCTS.put(p.getId(), p);
    }

    for (Accessory p : ACCESSORIES.values()) {
      PRODUCTS.put(p.getId(), p);
    }

    // There is a unique pair between product and category
    // As a result, let's find which products are associated
    // to which category so that we can perform a filter on them
    for (Product p : PRODUCTS.values()) {
      for (Category c : p.getCategories()) {
        Long id = c.getId();
        if (!CATEGORY_PRODUCT.containsKey(id)) {
          CATEGORY_PRODUCT.put(id, new ArrayList<Product>());
        }
        CATEGORY_PRODUCT.get(id).add(p);
      }
    }
  }

  private static Map<Long, Order> initiateOrders() {
    ORDER_SEQ_ID = -1L;
    List<Order> orders = Utils.readOrdersFromFile();
    if (orders != null && !orders.isEmpty()) {
      Map<Long, Order> result = new HashMap<Long, Order>(orders.size());
      for (Order order : orders) {
        System.out.println("Loading Orders");
        result.put(order.getId(), order);
        if (order.getId() > ORDER_SEQ_ID) {
          ORDER_SEQ_ID = order.getId();
        }
      }
      return result;
    } else {
      System.out.println("Initializing Orders");
      Map<Long, Order> result = new TreeMap<Long, Order>();
      resetSeq();
      result.clear();
      result.put(nextSeq(), new Order(getSeq(), "Some type of purchase " + getSeq(), Calendar.getInstance().getTime(), new BigDecimal(4.10), getRandomListOfProducts()));
      result.put(nextSeq(), new Order(getSeq(), "Some type of purchase " + getSeq(), Calendar.getInstance().getTime(), new BigDecimal(44.12), getRandomListOfProducts()));
      result.put(nextSeq(), new Order(getSeq(), "Some type of purchase " + getSeq(), Calendar.getInstance().getTime(), new BigDecimal(67.59), getRandomListOfProducts()));
      result.put(nextSeq(), new Order(getSeq(), "Some type of purchase " + getSeq(), Calendar.getInstance().getTime(), new BigDecimal(61.32), getRandomListOfProducts()));
      result.put(nextSeq(), new Order(getSeq(), "Some type of purchase " + getSeq(), Calendar.getInstance().getTime(), new BigDecimal(178.76), getRandomListOfProducts()));
      return result;
    }
  }

  private static void resetSeq() {
    dbId = -1L;
  }

  private static Long nextSeq() {
    return ++dbId;
  }

  private static Long getSeq() {
    return dbId;
  }

  private static List<Product> getRandomListOfProducts() {
    Random r = new Random();
    int i = r.nextInt(PRODUCTS.size());
    List<Product> result = new ArrayList<Product>(i);
    for (int j = 0; j < i; j++) {
      long id = r.nextInt(PRODUCTS.size());
      result.add(PRODUCTS.get(id));
    }
    return result;
  }

}
