<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<meta charset="ISO-8859-1">
<title>${requestScope.bean.browserPageTitle}</title>

<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/csp595.css" rel="stylesheet">