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
  <div>&nbsp;</div>
  <div class="sidebar">
    <fieldset>
      <legend>Flavors</legend>
      <ol style="margin-bottom: 0px;">
        <li><a href="#">Flavor 1</a></li>
        <li><a href="#">Flavor 2</a></li>
        <li><a href="#">Flavor 3</a></li>
        <li><a href="#">Flavor 4</a></li>
      </ol>
    </fieldset>
  </div>
</div>

<div class="col-10">
  <h3>Products</h3>
  <table class="table">
    <tbody>
      <tr>

        <c:set value="${requestScope.bean.parsedCurrentCategories}" var="categories" />
        <c:set value="&se=${param.se}" var="search" />

        <!-- Clean this up? -->
        <c:set value="&so=1" var="s1" />
        <c:set value="&so=3" var="s2" />
        <c:if test="${param.so == 1 || param.so == 2}">
          <c:set value="&so=${param.so == 1 ? 2 : 1}" var="s1" />
        </c:if>
        <c:if test="${param.so == 3 || param.so == 4}">
          <c:set value="&so=${param.so == 3 ? 4 : 3}" var="s2" />
        </c:if>

        <th class="col"></th>
        <th class="col"><a href="product?c=${categories}${param.se == null ? '' : search}${s2}">Item &#x25B4;&#x25BE;</a></th>
        <th class="col col_descrip_list">Description</th>
        <th class="col col_price_list"><a href="product?c=${categories}${param.se == null ? '' : search}${s1}">Price &#x25B4;&#x25BE;</a></th>
      </tr>

      <c:forEach items="${requestScope.bean.items}" var="item">
        <tr>
          <td><img class="group" src="images/product/${item.id}.jpg"></td>
          <td><a href="product?id=${item.id}"> ${item.name}</a></td>
          <td><p>${fn:substring(item.description, 0, 500)}...</p></td>
          <td class="cell_price"><fmt:formatNumber value="${item.price}" type="currency" /></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <jsp:include page="/WEB-INF/global/pagination.jsp">
    <jsp:param name="url" value="product" />
  </jsp:include>

</div>
