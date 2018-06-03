<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message text="Feeds"/></title>
</head>
<body>

<h1><spring:message text="Feeds"/></h1>
<table border="1">
    <tr>
        <th><spring:message text="ID"/></th>
        <th><spring:message text="Status"/></th>
        <th><spring:message text="Title"/></th>
        <th><spring:message text="Url"/></th>
        <th><spring:message text="Job interval"/></th>
        <th><spring:message text="Next Job"/></th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach items="${feedsList}" var="feed">
        <tr>
            <td>${feed.id}</td>
            <td>${feed.status}</td>
            <td>${feed.title}</td>
            <td>${feed.feedUrl}</td>
            <td>${feed.jobInterval}</td>
            <td>${feed.nextJob}</td>
            <td><a href="<c:url value="/feeds/${feed.id}/"/>">edit</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
