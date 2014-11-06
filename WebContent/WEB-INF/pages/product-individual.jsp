<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-10">

  <img src="images/product/${requestScope.bean.item.id}.jpg">
  <h3>${requestScope.bean.item.name}</h3>
  <p>${requestScope.bean.item.description}</p>
  <p>Price - ${requestScope.bean.item.price}</p>
</div>

<div class="col-2 sidebar">
  <div>
    <h4>Item Actions</h4>
    <ol class="list-unstyled">
      <li><form action="product?a=1&p=${requestScope.bean.item.id}" method="post">
          <button type="submit">Add to Cart</button>
        </form></li>
    </ol>
  </div>
</div>