<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="title" value="Posts" scope="request"/>

<!doctype html>
<html>
<jsp:include page="../include/metadata.jsp"/>
<body>

<jsp:include page="../include/header.jsp"/>

<nav class="subnav">
    <a href="<spring:url value='/feeds/'/>">Feeds</a>
</nav>

<main>

    <table class="table_list">
        <tr>
            <th class="numeric"><spring:message text="ID"/></th>
            <th><spring:message text="Author"/></th>
            <th><spring:message text="Title"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${postList}" var="post">
            <tr>
                <td class="numeric">${post.id}</td>
                <td>${post.author}</td>
                <td>${post.title}</td>
                <td class="td_buttons"><a href="<spring:url value="/posts/view/${post.id}/"/>">view</a></td>
            </tr>
        </c:forEach>
    </table>

</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
