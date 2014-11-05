<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if
  test="${requestScope.bean.message != null && requestScope.bean.message.error}">
  <div class="error">
    <ul>
      <li>${requestScope.bean.message.content}</li>
    </ul>
  </div>
</c:if>

<c:if test="${not empty param.error}">
  <div class="error">
    <ul>
      <li>${param.error}</li>
    </ul>
  </div>
</c:if>

<c:if
  test="${requestScope.bean.message != null && !requestScope.bean.message.error}">
  <div class="info">
    <ul>
      <li>${requestScope.bean.message.content}</li>
    </ul>
  </div>
</c:if>

<c:if test="${not empty param.info}">
  <div class="info">
    <ul>
      <li>${param.info}</li>
    </ul>
  </div>
</c:if>