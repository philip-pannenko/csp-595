package iit.csp595.domain.dao;

import iit.csp595.SortType;
import iit.csp595.domain.Database;
import iit.csp595.domain.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class ProductDao {

  public Product get(Long id) {
    return Database.PRODUCTS.get(id);
  }

  private List<Product> getProductsForCategory(long[] categoryTypeIds, final int sortTypeId, String search) {
    List<Product> result;
    if (categoryTypeIds[0] == -1L) {
      result = new ArrayList<Product>(Database.PRODUCTS.values());
    } else {
      Set<Product> unique = new HashSet<Product>();
      for (long categoryTypeId : categoryTypeIds) {
        if (categoryTypeId != -1) {
          if (Database.CATEGORY_PRODUCT.containsKey(categoryTypeId)) {
            unique.addAll(Database.CATEGORY_PRODUCT.get(categoryTypeId));
          }
        }
      }
      result = new ArrayList<Product>(unique);
    }

    Collections.sort(result, new Comparator<Product>() {

      @Override
      public int compare(Product o1, Product o2) {
        return sortUtil(o1, o2, sortTypeId);
      }
    });

    if (search != null) {
      Iterator<Product> it = result.iterator();
      while (it.hasNext()) {
        Product p = it.next();
        if (!StringUtils.containsIgnoreCase(p.getDescription(), search) && !StringUtils.containsIgnoreCase(p.getName(), search)) {
          it.remove();
        }
      }

    }

    return result;
  }

  private static int sortUtil(Product o1, Product o2, int sortTypeId) {
    switch (SortType.getSortTypeFromId(sortTypeId)) {
    case PRICE_ASC:
      return new BigDecimal(o1.getPrice()).compareTo(new BigDecimal(o2.getPrice()));
    case PRICE_DESC:
      return new BigDecimal(o2.getPrice()).compareTo(new BigDecimal(o1.getPrice()));
    case NAME_ASC:
      return o1.getName().compareTo(o2.getName());
    case NAME_DESC:
      return o2.getName().compareTo(o1.getName());
    default:
      return 0;
    }

  }

  public SearchResult getAll(int offset, int max, long[] categoryTypeIds, int sortTypeId, String search) {
    SearchResult result = new SearchResult();
    List<Product> items = new ArrayList<Product>(max);
    int counter = 0;

    Collection<Product> products = getProductsForCategory(categoryTypeIds, sortTypeId, search);
    result.count = products.size();
    for (Product p : products) {
      if (counter >= offset) {
        items.add(p);
      }
      counter++;
      if (items.size() == max) {
        break;
      }
    }

    result.items = items;
    return result;
  }

  public List<Product> findProducts(String search) {
    List<Product> result = new ArrayList<Product>();

    Collection<Product> products = Database.PRODUCTS.values();
    for (Product p : products) {
      if (p.getName().toLowerCase().startsWith(search.toLowerCase())) {
        result.add(p);
      } else if (p.getDescription().toLowerCase().contains(search.toLowerCase())) {
        result.add(p);
      }
    }

    return result;
  }

  public static class SearchResult {
    public List<Product> items;
    public int count;
  }

}
