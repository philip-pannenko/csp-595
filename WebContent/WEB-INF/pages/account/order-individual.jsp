<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="col-10">
  <h3>Individual Order</h3>

  <p>ID: ${requestScope.bean.item.id}</p>
  <p>
    OrderDate:
    <fmt:formatDate type="date" value="${requestScope.bean.item.orderDate}" />
  </p>
  <p>Description: ${requestScope.bean.item.description}</p>
  <p>
    Total Price:
    <fmt:formatNumber value="${requestScope.bean.item.totalPrice}" type="currency" />
  </p>

</div>

<div class="col-2 sidebar">
  <div>
    <h4>Order Actions</h4>
    <ol class="list-unstyled">
      <li><a href="#">Track Package</a></li>
      <li><a href="#">Cancel Order</a></li>
    </ol>
  </div>
</div>

