<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-10">

  <h3>Cart</h3>
  <table class="table">
    <tbody>
      <tr>
        <th scope="col">Image</th>
        <th scope="col">Name / Link</th>
        <th scope="col">Price</th>
        <th scope="col">Count</th>
        <th scope="col">Action</th>
      </tr>
      <c:forEach items="${requestScope.bean.item.products}" var="productId">
        <c:set var="product" value="${requestScope.bean.products[productId.key]}" />
        <tr>
          <td><img src="images/product/${product.id}.jpg"></td>
          <td><a href="product?id=${product.id}"> ${product.name}</a></td>
          <td><fmt:formatNumber value="${product.price * productId.value}" type="currency" /></td>
          <td>${productId.value}</td>
          <td><form action="cart?p=${product.id}" method="post">
              <button type="submit" name="a" value="2">Remove</button>
              |
              <button type="submit" name="a" value="3">Increment</button>
              |
              <button type="submit" name="a" value="4">Decrement</button>
            </form></td>
        </tr>
      </c:forEach>
      <tr>
        <th scope="col">Totals</th>
        <th />
        <th scope="col"><fmt:formatNumber value="${requestScope.bean.item.totalCost}" type="currency" /></th>
        <th scope="col">${requestScope.bean.item.totalProducts}</th>
      </tr>
    </tbody>
  </table>

</div>

<div class="col-2 sidebar">
  <div>
    <h4>Item Actions</h4>
    <ol class="list-unstyled">
      <li><a href="#">Checkout</a></li>
    </ol>
  </div>
</div>


