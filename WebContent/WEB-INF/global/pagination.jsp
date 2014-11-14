<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="text-align: center;" class="pagination">
  <nav>
    <ul>
      <c:forEach begin="1" end="${requestScope.bean.totalPages}" var="item">
        <c:set value="${requestScope.bean.parsedCurrentCategories}" var="categories" />
        <c:set value="&se=${param.se}" var="search"  />
        <c:set value="&so=${param.so}" var="sort"  />
        <c:set value="${param.url}" var="url" />

        <li class="${item == requestScope.bean.currentPage ? 'active' : ''}"><a href="${url}?p=${item}&c=${categories}${param.se == null ? '' : search}${param.so == null ? '' : sort}">${item} </a></li>
      </c:forEach>
    </ul>
  </nav>
</div>