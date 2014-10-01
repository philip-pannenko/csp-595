<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${requestScope.bean.message != null}">
  <div class="alert alert-danger">
    <ul>
      <li>${requestScope.bean.message.content}</li>
    </ul>
  </div>
</c:if>