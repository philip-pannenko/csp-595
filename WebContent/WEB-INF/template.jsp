<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/global/head.jsp" />
</head>

<body>
  <!-- This outer container is being added so that there is a 100% by 100% global target to use against for clicking -->
  <div id="container">
    <div class="container">

      <jsp:include page="/WEB-INF/global/header.jsp" />

      <div class="row">
        <jsp:include page="/WEB-INF/global/breadcrumb.jsp" />
        <jsp:include page="/WEB-INF/global/errors.jsp" />
        <jsp:include page="${requestScope.bean.pageDirFileName}" />
      </div>

      <jsp:include page="/WEB-INF/global/footer.jsp" />

    </div>
  </div>
</body>
</html>