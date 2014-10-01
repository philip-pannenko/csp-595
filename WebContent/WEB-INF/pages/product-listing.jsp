<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="jumbotron">
  <h1>Welcome to our shop!</h1>
  <h3>Take a look around.</h3>
</div>

<%@include file="/WEB-INF/global/left-nav.jsp"%>

<div class="col-xs-10">

  <c:forEach items="${requestScope.bean.items}" var="item">
    <div class="row product-listing">

      <div class="col-xs-5" style="text-align: center;">
        <img src="images/product/${item.id}.jpg">
      </div>
      <div class="col-xs-5">
        <h3 style="margin-top: 0px;">
          <a href="product?id=${item.id}"> ${item.name}</a>
        </h3>
        <p>${fn:substring(item.description, 0, 500)}...</p>
        <p>genre: ${item.genre}</p>
        <p>price: ${item.price}</p>
      </div>
    </div>
  </c:forEach>

</div>