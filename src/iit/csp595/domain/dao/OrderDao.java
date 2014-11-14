package iit.csp595.domain.dao;

import iit.csp595.Utils;
import iit.csp595.domain.Database;
import iit.csp595.domain.model.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDao {

  public Order get(Long id) {
    return Database.ORDERS.get(id);
  }

  public List<Order> getAllForUser(long userId) {
    List<Order> result = new ArrayList<Order>();
    for (Order p : Database.ORDERS.values()) {
      if (p.getUser() != null && p.getUser().getId().equals(userId)) {
        result.add(p);
      }
    }
    return result;
  }

  public void createOrder(Order order) {
    Database.ORDERS.put(order.getId(), order);
    if (!Database.USER_ORDERS.containsKey(order.getUser().getId())) {
      Database.USER_ORDERS.put(order.getUser().getId(), new ArrayList<Order>());
    }
    Database.USER_ORDERS.get(order.getUser().getId()).add(order);
    Utils.writeOrderToFile(order);
  }

  public void cancelOrder(Long id) {
    Utils.deleteOrderFromFile(id);
    Database.ORDERS.remove(id);
  }

}
