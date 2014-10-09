<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="/WEB-INF/pages/account/account-sidebar.jsp" />

<jsp:include page="/WEB-INF/global/errors.jsp" />
<div class="col-2">&nbsp;</div>
<div class="col-4">
  <form method="POST">
    <fieldset>
      <legend>Personal Information</legend>
      <label for="fname">First Name</label>
      <input type="text" name="fname" id="fname">
      <label for="lname">Last Name</label>
      <input type="text" name="lname" id="lname">
      <label for="username">Username</label>
      <input type="text" name="username" id="username">
      <label for="password">Password</label>
      <input type="password" name="password" id="password">
      <button type="submit">Save</button>
    </fieldset>

    <fieldset>
      <legend>Shipping Details</legend>
      <label for="street">Street</label>
      <input type="text" name="street" id="street">
      <label for="city">City</label>
      <input type="text" name="city" id="city">
      <label for="zip">Zip</label>
      <input type="text" name="zip" id="zip">
      <label for="state">State</label>
      <input type="text" name="state" id="state">
      <button type="submit">Save</button>
    </fieldset>
  </form>

</div>
