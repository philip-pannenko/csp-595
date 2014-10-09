<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
  <a class="logo" href="">CSP-595 Shop</a>
  <nav class="float-right">
    <ul>
      <li><a href="">Home</a></li>
      <c:choose>
        <c:when test="${sessionScope.user != null}">
          <li><a href="account">Account</a>
          <li><a href="logout">Logout ${sessionScope.user.fname}</a></li>
        </c:when>
        <c:when test="${sessionScope.user == null}">
          <li><a href="login">Login</a></li>
        </c:when>
      </c:choose>
    </ul>
  </nav>
</header>
