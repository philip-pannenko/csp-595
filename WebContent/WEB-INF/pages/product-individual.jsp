<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/global/head.jsp"%>
</head>

<body>

  <%@include file="/WEB-INF/global/header.jsp"%>

  <div class="container">

    <div class="row">

      <ol class="breadcrumb">
        <li><a href="\csp-595">Home</a></li>
        <li><a href="\csp-595">Products</a></li>
        <li class="active">${product.name}</li>
      </ol>

      <div class="col-md-offset-1 col-xs-9">

        <img src="images/product/${product.id}.jpg">
        <h3>${product.name}</h3>
        <h6>Genre - ${product.genre}</h6>
        <p>${product.description}</p>
        <p>Price - ${product.price}</p>
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

    </div>
  </div>

  <%@include file="/WEB-INF/global/footer.jsp"%>

</body>
</html>