package iit.csp595.domain;

import iit.csp595.Utils;
import iit.csp595.domain.model.Accessory;
import iit.csp595.domain.model.Category;
import iit.csp595.domain.model.Coffee;
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
  private static Category dd, sb, filter, grinder, african, latin_american, asia_pacific, blend, decaf;

  // Needs to be public for new additions
  public static long ORDER_SEQ_ID;
  public static long USER_SEQ_ID;

  private Database() {
  }

  private static Map<Long, Product> initializeProducts() {
    Map<Long, Product> result = new HashMap<Long, Product>();

    long productSeqId = -1l;

    result
        .put(
            ++productSeqId,
            new Accessory(
                productSeqId,
                "Cuisinart Grind Central Coffee Grinder",
                "The Grind Central Coffee Grinder features a brushed stainless steel housing, and removable stainless bowl and blade assembly. With a 90-gram capacity and Measurement Markings, you can efficiently measure and grind the exact quantity of coffee beans you need - for up to 18 cups at once!",
                30.00D, grinder));

    result
        .put(
            ++productSeqId,
            new Accessory(
                productSeqId,
                "Able Brewing: Kone Coffee Filter",
                "Stainless steel reusable filter that allows for more oils and a fuller bodied cup of coffee than paper. Designated to create the best coffee possible for those seeking a sustainable alternative to paper filter. Fits KONE Brewing System and standard 6, 8 and 10 cup Chemex Coffee Makers. Food safe plastic structure support ring.",
                60.00D, filter));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "Original Blend",
                "The Original Blend, the blend that made Dunkin' Donuts® famous, features 100% Arabica beans, from Central and South America. We have been keeping America running with this great coffee for over 60 years. These 1 pound packages, which include approximately 2,000 beans, allow you to brew the delicious flavor you love from the convenience of your own kitchen.",
                8.99D, 16, dd, blend, latin_american));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "Dunkin' Decaf",
                "You love the fresh taste of Dunkin' Donuts Original Blend coffee but don't always need the extra boost. Now you can enjoy the flavor you want without the caffeine when you order our packaged Dunkin' Decaf Ground Coffee. Each cup dazzles your senses with a soothing aroma followed by the vivid taste of premium beans. Fulfill your taste cravings day or night by brewing a pot of our delicious decaffeinated blend.",
                8.99D, 16, dd, decaf, latin_american));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "French Vanilla",
                "Every day should start with the great taste and aroma of Dunkin' Donuts coffee. Make your morning even better by indulging in the smooth, classic flavor of French Vanilla coffee. We make it easy for you to order your favorite flavored coffee online and have it delivered right to your home or office.",
                8.99D, 16, dd, blend, latin_american));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "Dark Roast",
                "Find your darker side when you try Dunkin' Donuts Dark Roast ground coffee. The complex aromas and intricate flavors will tantalize your senses and leave you wondering why you ever chose a lighter brew. With its carefully brewed mix of 100% Arabica beans roasted darker for a bolder, richer taste with the signature smoothness, you'd expect from America's Favorite Coffee. Dare to be bold, and order a 1 pound package of our premium dark ground coffee for a full-flavored experience.",
                8.99D, 16, dd, blend, latin_american));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "Timor Mount Ramelau",
                "Cultivated near East Timor's Mount Ramelau, with only the ripest cherries harvested for processing, this medium-roast coffee produces a smooth, refined flavor. The lush, forested peak is East Timor's highest, where the earth is well nourished and the weather is perfectly temperate. The coffee is cultivated in the backyards of smallholder farmers who meticulously tend to each plant, selecting only the ripest cherries to create a flavorful cup.",
                11.99D, 10, sb, decaf, asia_pacific));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "Guatemala Laguna de Ayarza",
                "In addition to ideal soil composition, Guatemala's Laguna de Ayrza region also has the perfect combination of warm days and cold nights that allow the beans to mature slowly as their delicate flavors become deeper and more complex. This medium roast is rich and balanced with crisp citrus notes and a sweet, chocolaty mouthfeel.",
                11.99D, 10, sb, blend, latin_american));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "Starbucks® House Blend",
                "Welcome to Starbucks own House Blend. This blend of Latin American coffees is easy to drink, with light to medium body. This is our timeless signature blend and our most popular coffee. For your convenience, this coffee has been pre-ground for use in a drip coffeemaker.",
                11.95D, 16, sb, blend, african));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "Starbucks® Pike Place® Roast",
                "Our medium-roasted coffees are smooth, balanced and rich in flavor. Pike Place Roast is brewed fresh in our stores every day, and is inspired by our first store in Seattle's Pike Place Market. It's a smooth, well-rounded blend of Latin American coffees with subtly rich flavors of cocoa and toasted nuts – perfect for every day.",
                11.95D, 16, sb, blend, latin_american));

    result
        .put(
            ++productSeqId,
            new Coffee(
                productSeqId,
                "Starbucks® Dark Sumatra Roast",
                "Like the Sumatran tiger, this popular single-origin coffee makes its presence known.  It's big and bold with distinctive earthy aroma and lingering low notes.  The heavy, full body and concentrated herbal spice notes are hallmarks of great coffee from Sumatra and the pride of our most seasoned roasters.",
                9.49D, 16, sb, blend, asia_pacific));

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

    result.put(++categorySeqId, new Category(categorySeqId, "Africa", CategoryType.COFFEE_REGION));
    african = result.get(categorySeqId);

    result.put(++categorySeqId, new Category(categorySeqId, "Latin America", CategoryType.COFFEE_REGION));
    latin_american = result.get(categorySeqId);

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

    result.put(++categorySeqId, new Category(categorySeqId, "Asia-Pacific", CategoryType.COFFEE_REGION));
    asia_pacific = result.get(categorySeqId);

    return result;

  }

  private static Map<Long, User> loadUsers() {

    USER_SEQ_ID = -1l;
    List<User> users = Utils.readUsersFromFile();
    if (users != null && !users.isEmpty()) {
      Map<Long, User> result = new HashMap<Long, User>();
      for (User user : users) {
        result.put(user.getId(), user);
        if (user.getId() > USER_SEQ_ID) {
          USER_SEQ_ID = user.getId();
        }
      }
      return result;
    } else {
      Map<Long, User> result = new HashMap<Long, User>();
      return result;
    }
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
