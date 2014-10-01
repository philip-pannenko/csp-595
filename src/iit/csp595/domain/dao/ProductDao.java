package iit.csp595.domain.dao;

import java.util.Collection;
import iit.csp595.domain.Product;

public class ProductDao {

  public Product get(Long id) {
    return TempDB.products.get(id);
  }

  public Collection<Product> get() {
    return TempDB.products.values();
  }

}
