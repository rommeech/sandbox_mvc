<%--
  Created by IntelliJ IDEA.
  User: rparshin
  Date: 26.05.18
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feeds</title>
</head>
<body>

<h1>Feed / ${feed.id}</h1>
<table border="1">
    <tr>
        <td>ID</td>
        <td>${feed.id}</td>
    </tr>
    <tr>
        <td>Created</td>
        <td>${feed.dateCreated}</td>
    </tr>
    <tr>
        <td>Updated</td>
        <td>${feed.lastUpdated}</td>
    </tr>
    <tr>
        <td>Status</td>
        <td>${feed.status}</td>
    </tr>
    <tr>
        <td>Icon URL</td>
        <td>${feed.iconUrl}</td>
    </tr>
    <tr>
        <td>Logo URL</td>
        <td>${feed.logoUrl}</td>
    </tr>
    <tr>
        <td>Feed URL</td>
        <td>${feed.feedUrl}</td>
    </tr>
    <tr>
        <td>Title</td>
        <td>${feed.title}</td>
    </tr>
    <tr>
        <td>Author</td>
        <td>${feed.author}</td>
    </tr>
    <tr>
        <td>Description</td>
        <td>${feed.description}</td>
    </tr>
    <tr>
        <td>Job interval</td>
        <td>${feed.jobInterval}</td>
    </tr>
    <tr>
        <td>Next job</td>
        <td>${feed.nextJob}</td>
    </tr>
</table>

</body>
</html>
