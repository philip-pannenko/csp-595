<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="col-2 sidebar">
  <div>
    <h4>Settings Actions</h4>
    <ol class="list-unstyled">
      <li><a href="#">Delete Account</a></li>
    </ol>
  </div>
</div>

<div class="col-10">
  <div class="row">
    <div class="col-6">
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
          <input type="submit" value="Save">
        </fieldset>
      </form>
    </div>

    <div class="col-6">
      <form method="POST">
        <fieldset>
          <legend>Shipping Address</legend>
          <label for="street">Street</label>
          <input type="text" name="street" id="street">
          <label for="city">City</label>
          <input type="text" name="city" id="city">
          <label for="zip">Zip</label>
          <input type="text" name="zip" id="zip">
          <label for="state">State</label>
          <input type="text" name="state" id="state">
          <input type="submit" value="Save">
        </fieldset>
      </form>
    </div>
  </div>
  <div class="row">
    <div class="col-6">
      <form method="POST">
        <fieldset>
          <legend>Payment Method</legend>
          <label for="street">Number</label>
          <input type="text" name="street" id="street">
          <label for="city">Name on Card</label>
          <input type="text" name="city" id="city">
          <label for="zip">Expiration</label>
          <input type="text" name="zip" id="zip">
          <label for="type">Type</label>
          <input type="text" name="type" id="type">
          <input type="submit" value="Save">
        </fieldset>
      </form>
    </div>

    <div class="col-6">
      <form method="POST">
        <fieldset>
          <legend>Billing Address</legend>
          <label for="street">Street</label>
          <input type="text" name="street" id="street">
          <label for="city">City</label>
          <input type="text" name="city" id="city">
          <label for="zip">Zip</label>
          <input type="text" name="zip" id="zip">
          <label for="state">State</label>
          <input type="text" name="state" id="state">
          <input type="submit" value="Save">
        </fieldset>
      </form>
    </div>
  </div>
</div>