<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/global/head.jsp"%>
</head>

<body>

  <%@include file="/WEB-INF/global/header.jsp"%>

  <div class="container">

    <div class="col-xs-offset-3 col-xs-6" style="margin-top:20px;">

      <c:if test="${requestScope.error != null}"><div class="alert alert-danger" role="alert">${requestScope.error}</div></c:if>

      <form class="form-horizontal" method="POST"  role="form">

        <fieldset>

          <legend>Login Form</legend>

          <div class="form-group">
            <label for="username" class="col-xs-2 control-label">Username</label>
            <div class="col-sm-10">
              <input type="text" name="username" class="form-control"
                id="username">
            </div>
          </div>
          <div class="form-group">
            <label for="password" class="col-xs-2 control-label">Password</label>
            <div class="col-sm-10">
              <input type="password" name="password" class="form-control" id="password">
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-xs-10">
              <button type="submit" class="btn btn-default">Sign
                in</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>

  </div>

  <%@include file="/WEB-INF/global/footer.jsp"%>
</body>
</html>