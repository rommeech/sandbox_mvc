<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html>
<jsp:include page="include/metadata.jsp"/>
<body>

<jsp:include page="include/header.jsp"/>

<main>
    <h2><spring:message text="Welcome!"/></h2>
    <ul>
        <li><a href="<spring:url value='/feeds/'/>"><spring:message text="Feeds"/></a></li>
    </ul>
</main>

<jsp:include page="include/footer.jsp"/>

</body>
</html>

