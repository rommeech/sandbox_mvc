<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <h1><c:if test="${title != null}">${title} / </c:if>Sandbox MVC</h1>
</header>
<nav class="main-nav">
    <a href="<spring:url value='/feeds/'/>"><spring:message text="Feeds"/></a>
    <a href="<spring:url value='/bots/'/>"><spring:message text="Bots"/></a>
    <a href="<spring:url value='/channels/'/>"><spring:message text="Channels"/></a>
</nav>