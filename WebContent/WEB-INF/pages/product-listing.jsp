<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- <div class="jumbotron"> -->
<!--   <h1>Welcome to our shop!</h1> -->
<!--   <h3>Take a look around.</h3> -->
<!-- </div> -->

<%@include file="/WEB-INF/global/left-nav.jsp"%>

<div class="col-xs-10">

  <table class="table table-hover">
    <tbody>
      <c:forEach items="${requestScope.bean.items}" var="item">
        <tr>
          <td><img src="images/product/${item.id}.jpg"></td>
          <td><a href="product?id=${item.id}"> ${item.name}</a></td>
          <td><p>${fn:substring(item.description, 0, 500)}...</p></td>
          <td><p>genre: ${item.genre}</p></td>
          <td><p>price: ${item.price}</p></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <jsp:include page="/WEB-INF/global/pagination.jsp" />

</div>
