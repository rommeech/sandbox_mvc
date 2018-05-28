<%--
  Created by IntelliJ IDEA.
  User: rparshin
  Date: 26.05.18
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Feed</title>
</head>
<body>

<h1>Feeds</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Status</th>
        <th>Title</th>
        <th>Url</th>
        <th>Job interval</th>
        <th>Next Job</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach items="${feedList}" var="feed">
        <tr>
            <td>${feed.id}</td>
            <td>${feed.status}</td>
            <td>${feed.title}</td>
            <td>${feed.feedUrl}</td>
            <td>${feed.jobInterval}</td>
            <td>${feed.nextJob}</td>
            <td><a href="<%= request.getContextPath() %>/feeds/${feed.id}/">edit</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
