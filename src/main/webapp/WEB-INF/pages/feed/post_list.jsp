<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="title" value="Posts"/>

<!doctype html>
<html>
<jsp:include page="../include/metadata.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<body>

<jsp:include page="../include/header.jsp"/>

<main>
    <h1><spring:message text="Posts"/></h1>
    <nav>
        <a href="<spring:url value='/feeds/new/'/>">Add new feed</a>
    </nav>
    <table border="1">
        <tr>
            <th><spring:message text="ID"/></th>
            <th><spring:message text="Author"/></th>
            <th><spring:message text="Title"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${postList}" var="model">
            <tr>
                <td>${model.id}</td>
                <td>${model.author}</td>
                <td>${model.title}</td>
                <td><a href="<spring:url value="/posts/${model.id}/"/>">view</a></td>
            </tr>
        </c:forEach>
    </table>
</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
