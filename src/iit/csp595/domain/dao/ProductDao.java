package iit.csp595.domain.dao;

import java.util.ArrayList;
import java.util.List;

import iit.csp595.domain.Product;

public class ProductDao {

  public Product get(Long id) {
    return TempDB.products.get(id);
  }

  public int getCount() {
    return TempDB.products.size();
  }

  public List<Product> getAll() {
    return new ArrayList<Product>(TempDB.products.values());
  }

  public List<Product> getAll(int offset, int max) {
    List<Product> result = new ArrayList<Product>(max);
    for (int i = 0; i < TempDB.productsList.size(); i++) {
      if (i >= offset) {
        result.add(TempDB.productsList.get(i));
      }
      if (result.size() == max)
        break;
    }
    return result;
  }

}
