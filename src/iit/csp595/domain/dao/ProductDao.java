package iit.csp595.domain.dao;

import iit.csp595.domain.Product;
import iit.csp595.domain.type.SortType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDao {

  public Product get(Long id) {
    return TempDB.PRODUCTS.get(id);
  }

  public List<Product> getProductsForCategory(long[] categoryTypeIds, final int sortTypeId) {
    List<Product> result;
    if (categoryTypeIds[0] == -1L) {
      result = new ArrayList<Product>(TempDB.PRODUCTS.values());
    } else {
      Set<Product> unique = new HashSet<Product>();
      for (long categoryTypeId : categoryTypeIds) {
        unique.addAll(TempDB.CATEGORY_PRODUCT.get(categoryTypeId));
      }
      result = new ArrayList<Product>(unique);
    }
    Collections.sort(result, new Comparator<Product>() {

      @Override
      public int compare(Product o1, Product o2) {
        return sortUtil(o1, o2, sortTypeId);
      }
    });

    return result;
  }

  private static int sortUtil(Product o1, Product o2, int sortTypeId) {
    switch (SortType.getSortTypeFromId(sortTypeId)) {
    case PRICE_ASC:
      return new BigDecimal(o1.getPrice()).compareTo(new BigDecimal(o2.getPrice()));
    case PRICE_DESC:
      return new BigDecimal(o2.getPrice()).compareTo(new BigDecimal(o1.getPrice()));
    default:
      return 0;
    }

  }

  public List<Product> getAll(int offset, int max, long[] categoryTypeIds, int sortTypeId) {
    List<Product> result = new ArrayList<Product>(max);
    int counter = 0;

    Collection<Product> products = getProductsForCategory(categoryTypeIds, sortTypeId);

    for (Product p : products) {
      if (counter >= offset) {
        result.add(p);
      }
      counter++;
      if (result.size() == max) {
        break;
      }
    }
    return result;
  }

  public int getCount(long[] categoryTypeId, int sortTypeId) {
    return getProductsForCategory(categoryTypeId, sortTypeId).size();
  }

}
