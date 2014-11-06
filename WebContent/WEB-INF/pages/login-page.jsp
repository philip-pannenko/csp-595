<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-12">

  <div class="col-4">&nbsp;</div>
  <div class="col-4">
    <form action="auth?a=5" method="POST">
      <fieldset>
        <legend>Login Form</legend>
        <label for="username">Username</label>
        <input type="text" name="username" id="username">
        <label for="password">Password</label>
        <input type="password" name="password" id="password">
        <input type="submit" value="Sign in" />
      </fieldset>
    </form>
  </div>
</div>
