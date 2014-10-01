<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
  <div class="header">
    <ul class="nav nav-pills pull-right">
      <li><a href="\csp-595">Home</a></li>
      <c:choose>
        <c:when test="${sessionScope.user != null}">
          <li><a href="logout">Logout ${sessionScope.user.fname}</a></li>
        </c:when>
        <c:when test="${sessionScope.user == null}">
          <li><a href="login">Login</a></li>
        </c:when>
      </c:choose>
    </ul>
    <h3 class="text-muted">
      <a href="\csp-595">Shop</a>
    </h3>
  </div>
</div>