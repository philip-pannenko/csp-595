<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="col-2">
  <div class="sidebar">
    <form method="POST">
      <fieldset>
        <legend>Search</legend>
        <input style="width:100%" id="search">
        <button type="submit">Search</button>
      </fieldset>
    </form>
  </div>
  <div>&nbsp;</div>
  <div class="sidebar">
    <fieldset>
        <legend><a style="color: #333" href="product">Shop</a></legend>
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
    </fieldset>
  </div>  
  <div>&nbsp;</div>
  <div class="sidebar">
    <fieldset>
      <legend>Flavors</legend>
      <ol style="margin-bottom:0px;" >
        <li><a href="#">Flavor 1</a></li>
        <li><a href="#">Flavor 2</a></li>
        <li><a href="#">Flavor 3</a></li>
        <li><a href="#">Flavor 4</a></li>
      </ol>
    </fieldset>
  </div>
</div>

<div class="col-10">
  <h3>Products</h3>
  <table class="table">
    <tbody>
      <tr>
        <th scope="col"> </th>
        <th scope="col">Item</th>
        <th class="col_descrip_list" scope="col">Description</th>
        <th class="col_price_list" scope="col">Price</th>
      </tr>
      <c:forEach items="${requestScope.bean.items}" var="item">
        <tr>
          <td><img class="group" src="images/product/${item.id}.jpg"></td>
          <td><a href="product?id=${item.id}"> ${item.name}</a></td>
          <td><p>${fn:substring(item.description, 0, 500)}...</p></td>
          <td class="cell_price"><p>${item.price}</p></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <jsp:include page="/WEB-INF/global/pagination.jsp">
    <jsp:param name="url" value="product" />
  </jsp:include>

</div>
