<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-xs-offset-3 col-xs-6" style="margin-top: 20px;">

  <jsp:include page="/WEB-INF/global/errors.jsp"/>

  <form class="form-horizontal" method="POST">

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
          <input type="password" name="password" class="form-control"
            id="password">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-xs-10">
          <button type="submit" class="btn btn-default">Sign in</button>
        </div>
      </div>
    </fieldset>
  </form>
</div>
