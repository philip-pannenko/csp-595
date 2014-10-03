package iit.csp595.domain.dao;

import iit.csp595.domain.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDao {

  public Product get(Long id) {
    return TempDB.PRODUCTS.get(id);
  }

  public Collection<Product> getProductsForCategory(long... categoryTypeIds) {
    if (categoryTypeIds[0] == -1L) {
      return TempDB.PRODUCTS.values();
    }
    Set<Product> result = new HashSet<Product>();
    for (long categoryTypeId : categoryTypeIds) {
      result.addAll(TempDB.CATEGORY_PRODUCT.get(categoryTypeId));
    }
    return result;
  }

  public List<Product> getAll(int offset, int max, long... categoryTypeIds) {
    List<Product> result = new ArrayList<Product>(max);
    int counter = 0;

    Collection<Product> products = getProductsForCategory(categoryTypeIds);

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

  public int getCount(long[] categoryTypeId) {
    return getProductsForCategory(categoryTypeId).size();
  }

}
