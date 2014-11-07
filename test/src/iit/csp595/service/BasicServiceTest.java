package iit.csp595.service;

import java.util.Collection;

import iit.csp595.SortType;
import iit.csp595.domain.dao.ProductDao;
import iit.csp595.domain.model.Product;

import org.junit.Test;

public class BasicServiceTest {

  @Test
  public void test() {

    logger("No Sort", new ProductDao().getProductsForCategory(new long[] {-1L}, SortType.NOT_APPLICABLE.getId()));
    logger("Ascending", new ProductDao().getProductsForCategory(new long[] {-1L}, SortType.PRICE_ASC.getId()));
    logger("Descending", new ProductDao().getProductsForCategory(new long[] {-1L}, SortType.PRICE_DESC.getId()));
  }

  private static void logger(String msg, Collection<Product> products) {
    System.out.println(msg);
    for (Product p : products) {
      System.out.println(p);
    }
  }

}
