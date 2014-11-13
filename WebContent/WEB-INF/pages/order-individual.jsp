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


  <h4>Products Associated w/ Order</h4>
  <table class="table">
    <tbody>
      <tr>
        <th scope="col">Image</th>
        <th scope="col">Name / Link</th>
        <th scope="col">Price</th>
        <th scope="col">Count</th>
      </tr>
      <c:forEach items="${requestScope.bean.item.products}" var="productId">
        <c:set var="product" value="${requestScope.bean.products[productId.key]}" />
        <tr>
          <td><img class="individual" src="images/product/${product.id}.jpg"></td>
          <td><a href="product?id=${product.id}"> ${product.name}</a></td>
          <td><fmt:formatNumber value="${product.price * productId.value}" type="currency" /></td>
          <td>${productId.value}</td>
        </tr>
      </c:forEach>
      <tr>
        <th scope="col">Totals</th>
        <th />
        <th scope="col"><fmt:formatNumber value="${requestScope.bean.item.totalPrice}" type="currency" /></th>
      </tr>
    </tbody>
  </table>

</div>

<div class="col-2 sidebar">
  <div>
    <h4>Order Actions</h4>
    <form action="account/order?a=7&o=${requestScope.bean.item.id}" method="POST">
      <ol class="list-unstyled">
        <c:if test="${requestScope.bean.orderCancelable}">
          <li><button type="submit">Cancel Order</button></li>
        </c:if>
      </ol>
    </form>
  </div>
</div>

