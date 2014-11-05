package iit.csp595.domain.dao;

import iit.csp595.domain.Database;
import iit.csp595.domain.model.Order;
import iit.csp595.domain.model.type.SortType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderDao {

  public Order get(Long id) {
    return Database.ORDERS.get(id);
  }

  public List<Order> getSortedOrders(final int sortTypeId) {
    List<Order> result;
    result = new ArrayList<Order>(Database.ORDERS.values());

    Collections.sort(result, new Comparator<Order>() {

      @Override
      public int compare(Order o1, Order o2) {
        return sortUtil(o1, o2, sortTypeId);
      }
    });

    return result;
  }

  private static int sortUtil(Order o1, Order o2, int sortTypeId) {
    switch (SortType.getSortTypeFromId(sortTypeId)) {
    case PRICE_ASC:
      return o1.getTotalPrice().compareTo(o2.getTotalPrice());
    case PRICE_DESC:
      return o2.getTotalPrice().compareTo(o1.getTotalPrice());
    default:
      return 0;
    }

  }

  public List<Order> getAll(int offset, int max, int sortTypeId) {
    List<Order> result = new ArrayList<Order>(max);
    int counter = 0;

    Collection<Order> products = getSortedOrders(sortTypeId);

    for (Order p : products) {
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

  public int getCount(int sortTypeId) {
    return getSortedOrders(sortTypeId).size();
  }

}
