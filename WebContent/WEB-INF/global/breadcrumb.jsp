<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${requestScope.bean!=null && requestScope.bean.breadcrumb != null}">
  <nav class="breadcrumb">
    <ul>
      <c:forEach items="${requestScope.bean.breadcrumb}" var="item" varStatus="status">
        <c:choose>
          <c:when test="${!status.last}">
            <li><a href="${item.value}">${item.key}</a> /</li>
          </c:when>
          <c:otherwise>
            <li>${item.key}</li>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </ul>
  </nav>
</c:if>