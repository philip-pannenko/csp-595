<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
  <img src='images/store_header.jpg' />
  <nav class="float-right">
    <ul>
      <li><a href="">Products</a></li>
      <li><a href="cart">Cart</a></li>
      <c:choose>
        <c:when test="${sessionScope.user != null}">
          <li><a href="account">Account</a>
          <li><a href="auth?a=6">Logout ${sessionScope.user.fname}</a></li>
        </c:when>
        <c:when test="${sessionScope.user == null}">
          <li><a href="auth">Login</a></li>
          <li><a href="account?a=15">Sign-Up</a></li>
        </c:when>
      </c:choose>
    </ul>
  </nav>
</header>
