<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <div id="logo">
        <h1>Sandbox MVC</h1>
    </div>

    <nav id="header_nav">
        <a href="<spring:url value='/feeds/'/>"><spring:message text="Feeds"/></a>
        <a href="<spring:url value='/bots/'/>"><spring:message text="Bots"/></a>
        <a href="<spring:url value='/channels/'/>"><spring:message text="Channels"/></a>
    </nav>
</header>
