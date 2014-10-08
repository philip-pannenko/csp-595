<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="text-align: center;">
  <nav class="pagination">
    <ul>
      <c:forEach begin="1" end="${requestScope.bean.totalPages}" var="item">
        <li class="${item == requestScope.bean.currentPage ? 'active' : ''}"><a href="product?page=${item}&c=${requestScope.bean.parsedCurrentCategories}">${item} </a></li>
      </c:forEach>
    </ul>
  </nav>
</div>