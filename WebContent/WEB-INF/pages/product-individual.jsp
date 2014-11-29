<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-10">

  <img class="individual" src="images/product/${requestScope.bean.item.id}.jpg">
  <h3>${requestScope.bean.item.name}</h3>
  <p>${requestScope.bean.item.description}</p>
  <p>Price - ${requestScope.bean.item.price}</p>
</div>

<div class="col-2 sidebar">
  <form action="product?a=1&p=${requestScope.bean.item.id}" method="post">
    <fieldset>
      <legend>Product</legend>
      <ol class="list-unstyled">
        <li>
          <button style="width: 100%;" type="submit">Add to Cart</button>
        </li>
      </ol>
    </fieldset>
  </form>
</div>