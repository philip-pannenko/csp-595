<%@ page isErrorPage="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/global/head.jsp" />
</head>

<body>
  <div class="container">

    <jsp:include page="/WEB-INF/global/header.jsp" />

    <div class="row text-center">
      <h2>${requestScope['javax.servlet.error.status_code']} Error</h2>
      Oops! What'd ya do! Here's some debugging information...
    </div>
    <div>

      <p>
        sessionScope : <span>${sessionScope}</span>
      </p>
      <p>
        requestScope : <span> ${requestScope} </span>
      </p>
      <p>
        pageScope : <span>${pageScope}</span>
      </p>

      <ul>
        <li>Exception: <c:out value="${requestScope['javax.servlet.error.exception']}" /></li>
        <li>Exception type: <c:out value="${requestScope['javax.servlet.error.exception_type']}" /></li>
        <li>Exception message: <c:out value="${requestScope['javax.servlet.error.message']}" /></li>
        <li>Request URI: <c:out value="${requestScope['javax.servlet.error.request_uri']}" /></li>
        <li>Servlet name: <c:out value="${requestScope['javax.servlet.error.servlet_name']}" /></li>
        <li>Status code: <c:out value="${requestScope['javax.servlet.error.status_code']}" /></li>
      </ul>
    </div>

    <jsp:include page="/WEB-INF/global/footer.jsp" />

  </div>
</body>
</html>

