<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div style="text-align: center;" class="pagination">
  <nav>
    <ul>
      <c:forEach begin="1" end="${requestScope.bean.totalPages}" var="item">
        <c:set value="${requestScope.bean.parsedCurrentCategories}" var="categories" />
        <c:set value="&se=${param.se}" var="search"  />
        <c:set value="&so=${param.so}" var="sort"  />
        <c:set value="&a=1" var="ajax" />
        <c:set value="${param.url}" var="url" />

        <li><a style="cursor:pointer;" onmouseup="doAjaxForPagination(${item})"> ${item}</a></li>
     </c:forEach>
    </ul>
  </nav>
</div>