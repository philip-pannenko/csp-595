<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<%@include file="/WEB-INF/global/left-nav.jsp"%>

<div class="col-10">

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

  <jsp:include page="/WEB-INF/global/pagination.jsp" />

</div>
