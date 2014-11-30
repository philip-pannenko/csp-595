<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set value="?c=${requestScope.bean.parsedCurrentCategories}" var="categories" />
<c:set value="&se=${(param.se == null ? '' : param.se)}" var="search" />
<c:set value="&a=1" var="ajax" />

<c:set value="${categories}${search}${ajax}" var="baseUrl" />
<c:set value="${baseUrl}&so=${sortTypeId == 3 ? 4 : 3}" var="sortItemUrl" />
<c:set value="${baseUrl}&so=${sortTypeId == 1 ? 2 : 1}" var="sortPriceUrl" />
<c:set value="${baseUrl}&so=${sortTypeId}" var="paginationUrl"/>

<input type="hidden" id='sortItemUrl' name='sortItemUrl' value='${sortItemUrl}' />
<input type="hidden" id='sortPriceUrl' name='sortPriceUrl' value='${sortPriceUrl}' />
<input type='hidden' id='paginationUrl' name='paginationUrl' value='${paginationUrl}' />;

<table class="table">
  <tbody>
    <tr>
      <th class="col"></th>
      <th class="col"><a onmouseup='doAjaxForItem()'>Item &#x25B4;&#x25BE;</a></th>
      <th class="col col_descrip_list">Description</th>
      <th class="col col_price_list"><a onmouseup='doAjaxForPrice()'>Price &#x25B4;&#x25BE;</a></th>
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