<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-offset-1 col-xs-9">

  <img src="images/product/${requestScope.bean.item.id}.jpg">
  <h3>${requestScope.bean.item.name}</h3>
  <p>${requestScope.bean.item.description}</p>
  <p>Price - ${requestScope.bean.item.price}</p>
</div>

<div class="col-xs-2">
  <div>
    <h4>Item Actions</h4>
    <ol class="list-unstyled">
      <li><a href="#">Add to cart</a></li>
      <li><a href="#">Add to wishlist</a></li>
    </ol>
  </div>
</div>

