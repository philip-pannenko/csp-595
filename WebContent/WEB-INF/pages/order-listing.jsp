<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="col-2 sidebar">
  <div>
    <h4>Order Actions</h4>
    <ol class="list-unstyled">
      <li><a href="#">Recent Orders</a></li>
      <li><a href="#">Delivered Orders</a></li>
    </ol>
  </div>
</div>

<div class="col-10">
<h3>Your Orders</h3>
  <table class="table">
    <tbody>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Order Date</th>
        <th scope="col">Items Purchased</th>
        <th scope="col">Price</th>
      </tr>
      <c:forEach items="${requestScope.bean.items}" var="item">
        <tr>
          <td><a href="account/order?id=${item.id}"> ${item.id}</a></td>
          <td><fmt:formatDate type="date" value="${item.orderDate}" /></td>
          <td>${fn:substring(item.description, 0, 500)}...</td>
          <td><fmt:formatNumber value="${item.totalPrice}" type="currency" /></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <jsp:include page="/WEB-INF/global/pagination.jsp">
    <jsp:param name="url" value="account/order" />
  </jsp:include>

</div>
