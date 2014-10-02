<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/global/head.jsp" />
</head>

<body>
  <jsp:include page="/WEB-INF/global/header.jsp" />

  <div class="container">

    <div class="row">

      <jsp:include page="/WEB-INF/global/breadcrumb.jsp" />
      <jsp:include page="${requestScope.bean.pageDirFileName}" />

    </div>
  </div>

  <jsp:include page="/WEB-INF/global/footer.jsp" />
</body>
</html>