<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/global/head.jsp" />
</head>

<body style="background-color: #f9f9f9">
  <div style="background-color: white;">
    <div class="container">

      <jsp:include page="/WEB-INF/global/header.jsp" />

      <div class="row">

        <jsp:include page="/WEB-INF/global/breadcrumb.jsp" />

        <jsp:include page="${requestScope.bean.pageDirFileName}" />
      </div>
    </div>
  </div>

  <jsp:include page="/WEB-INF/global/footer.jsp" />

</body>
</html>