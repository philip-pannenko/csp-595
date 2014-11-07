<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="col-2 sidebar">
  <h5><a style="color: #333" href="product">Shop</a></h5>
  <ul class="tree">
    <li><h5><a href="product?c=0,1,2,3,4,5">Coffee</a></h5>
      <ul>
        <li><h5><a href="product?c=2,3">Store</a></h5>
          <ul>
            <li><a href="product?c=2">Starbucks</a></li>
            <li><a href="product?c=3">Dunkin Donuts</a></li>
          </ul>
        </li>
        <li><h5><a href="product?c=0,1">Region</a></h5>
          <ul>
            <li><a href="product?c=0">African</a></li>
            <li><a href="product?c=1">Local</a></li>
          </ul>
        </li>
        <li><h5><a href="product?c=4,5">Bean Type</a></h5>
          <ul>
            <li><a href="product?c=4">Blend</a></li>
            <li><a href="product?c=5">Decaf</a></li>
          </ul>
        </li>
      </ul>
    </li>
    <li><h5><a href="product?c=6,7">Accessories</a></h5>
      <ul>
        <li><a href="product?c=6">Grinder</a></li>
        <li><a href="product?c=7">Filter</a></li>
      </ul>
    </li>
  </ul>
</div>

<div class="col-10">
  <h3>Products</h3>
  <table class="table">
    <tbody>
      <tr>
        <th scope="col">Image</th>
        <th scope="col">Name / Link</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
      </tr>
      <c:forEach items="${requestScope.bean.items}" var="item">
        <tr>
          <td><img src="images/product/${item.id}.jpg"></td>
          <td><a href="product?id=${item.id}"> ${item.name}</a></td>
          <td><p>${fn:substring(item.description, 0, 500)}...</p></td>
          <td><p>${item.price}</p></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <jsp:include page="/WEB-INF/global/pagination.jsp">
    <jsp:param name="url" value="product" />
  </jsp:include>

</div>
