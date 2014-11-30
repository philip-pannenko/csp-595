<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="col-2">
  <div class="sidebar">
    <script src="scripts/ajax-utils.js" type="text/javascript"></script>
    <form action="product" method='GET'>
      <fieldset>
        <legend>Search</legend>
        <div class="search-result-form">
          <input style="width: 100%" type="text" onkeyup='searchAutoComplete()' id="se" name="se" value="${param.se}" />
          <button value="submit">Search</button>
          <button value="submit" onclick="se.value=''" style="margin-right: 10px;">Clear</button>
          <div id="search-results" class="search-result-items"></div>
        </div>
      </fieldset>
    </form>
  </div>
  <div>&nbsp;</div>
  <div class="sidebar">
    <fieldset>
      <legend>
        <a style="color: #333" href="product">Shop</a>
      </legend>
      <ul class="tree">
        <li><h5>
            <a href="product?c=0,1,2,3,4,5,8">Coffee</a>
          </h5>
          <ul>
            <li><h5>
                <a href="product?c=2,3">Store</a>
              </h5>
              <ul>
                <li><a class="click" href="product?c=2">Starbucks</a></li>
                <li><a class="click" href="product?c=3">Dunkin Donuts</a></li>
              </ul></li>
            <li><h5>
                <a href="product?c=0,1,8">Region</a>
              </h5>
              <ul>
                <li><a class="click" href="product?c=0">Africa</a></li>
                <li><a class="click" href="product?c=1">Latin America</a></li>
                <li><a class="click" href="product?c=8">Asia-Pacific</a></li>
              </ul></li>
            <li><h5>
                <a href="product?c=4,5">Bean Type</a>
              </h5>
              <ul>
                <li><a class="click" href="product?c=4">Blend</a></li>
                <li><a class="click" href="product?c=5">Decaf</a></li>
              </ul></li>
          </ul></li>
        <li><h5>
            <a href="product?c=6,7">Accessories</a>
          </h5>
          <ul>
            <li><a class="click" href="product?c=6">Grinder</a></li>
            <li><a class="click" href="product?c=7">Filter</a></li>
          </ul></li>
      </ul>
    </fieldset>
  </div>
</div>

<div class="col-10">
  <h3>Products</h3>
  <div id="replaceMe">
    <jsp:include page="/WEB-INF/pages/product-listing-fragment.jsp" />
  </div>
</div>