package iit.csp595.service;

import iit.csp595.bean.GenericPageBean;
import iit.csp595.bean.Message;
import iit.csp595.bean.account.OrderIndividualBean;
import iit.csp595.bean.account.OrderListingBean;
import iit.csp595.bean.product.ProductIndividualBean;
import iit.csp595.bean.product.ProductListingBean;
import iit.csp595.domain.dao.OrderDao;
import iit.csp595.domain.dao.ProductDao;
import iit.csp595.domain.object.Order;
import iit.csp595.domain.object.Product;

import java.util.List;

public class OrderService implements Service<Order> {

  private int nextPage;
  private int sortTypeId;
  private OrderDao dao;
  private long productId = -1L;

  public OrderService(long productId, int nextPage, int sortTypeId) {
    super();
    this.dao = new OrderDao();
    this.productId = productId;
    this.nextPage = nextPage;
    this.sortTypeId = sortTypeId;
  }

  @Override
  public GenericPageBean<Order> createBean() {
    if (productId == -1) {

      int offset = nextPage - 1;
      int totalProductsCount = dao.getCount(sortTypeId);
      List<Order> products = dao.getAll(offset * 2, 2, sortTypeId);
      OrderListingBean bean = new OrderListingBean(products, totalProductsCount);

      bean.setCurrentPage(nextPage);

      return bean;
    } else {

      Order p = dao.get(productId);
      OrderIndividualBean bean = new OrderIndividualBean(p);
      if (p == null) {
        bean.setMessage(new Message("error", "Could not find that thing"));
      }
      return bean;
    }
  }

}
