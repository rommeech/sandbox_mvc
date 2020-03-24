<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <title><c:if test="${title != null}">${title} / </c:if><spring:message code="project.meta.title"/></title>
    <meta http-equiv=Content-Type content="text/html;charset=UTF-8" />
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>" />
    <script src="<c:url value='/resources/js/lib/vue.js'/>"></script>
    <!-- script src="<c:url value='/resources/js/header.js'/>"></script -->
</head>
