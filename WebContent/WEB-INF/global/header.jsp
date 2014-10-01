<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- <div class="header"> -->
<!--   <ul class="nav nav-pills pull-right"> -->
<!--     <li><a href="\csp-595">Home</a></li> -->
<%--     <c:choose> --%>
<%--       <c:when test="${sessionScope.user != null}"> --%>
<%--         <li><a href="logout">Logout ${sessionScope.user.fname}</a></li> --%>
<%--       </c:when> --%>
<%--       <c:when test="${sessionScope.user == null}"> --%>
<!--         <li><a href="login">Login</a></li> -->
<%--       </c:when> --%>
<%--     </c:choose> --%>
<!--   </ul> -->
<!--   <h3 class="text-muted"> -->
<!--     <a href="\csp-595">Shop</a> -->
<!--   </h3> -->
<!-- </div> -->


<nav class="navbar navbar-default">
  <div class="container">

    <div class="navbar-header">
      <a class="navbar-brand" href="#">CSP-595 Shop</a>
    </div>

    <form class="navbar-form navbar-left">
      <div class="input-group">
        <input type="text" class="form-control"
          placeholder="Search our store!"> <span
          class="input-group-btn">
          <button class="btn btn-default" type="button">Go!</button>
        </span>
      </div>
    </form>

    <div>
      <ul class="nav navbar-nav navbar-right">
        <c:choose>
          <c:when test="${sessionScope.user != null}">
            <li><a href="logout">Logout
                ${sessionScope.user.fname}</a></li>
          </c:when>
          <c:when test="${sessionScope.user == null}">
            <li><a href="login">Login</a></li>
          </c:when>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>
