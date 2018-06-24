<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="title" value="Sandbox MVC"/>

<!doctype html>
<html>
<jsp:include page="include/metadata.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<body>

<jsp:include page="include/header.jsp"/>

<main>

    <h1><spring:message text="Welcome!"/></h1>

    <ul>
        <li><a href="<spring:url value='/feeds/'/>"><spring:message text="Feeds"/></a></li>
    </ul>

</main>

<jsp:include page="include/footer.jsp"/>

</body>
</html>

