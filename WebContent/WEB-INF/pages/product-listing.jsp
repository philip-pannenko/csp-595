<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
        <li class="active">Products</li>
      </ol>

      <div class="jumbotron">
        <h1>Welcome to our shop!</h1>
        <h3>Take a look around.</h3>
      </div>

      <%@include file="/WEB-INF/global/left-nav.jsp"%>

      <div class="col-xs-10">

        <c:forEach items="${requestScope.products}" var="item">
          <div class="row product-listing">

            <div class="col-xs-5" style="text-align: center;">
              <img src="images/product/${item.key}.jpg">
            </div>
            <div class="col-xs-5">
              <h3 style="margin-top: 0px;">
                <a href="product?id=${item.key}"> ${item.value.name}</a>
              </h3>
              <p>${fn:substring(item.value.description, 0, 500)}...</p>
              <p>genre: ${item.value.genre}</p>
              <p>price: ${item.value.price}</p>
            </div>
          </div>
        </c:forEach>

      </div>
    </div>
  </div>

  <%@include file="/WEB-INF/global/footer.jsp"%>
</body>
</html>