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
    <style>
        input { width: 95%; }
        td { padding: 2px 5px 2px 5px; }
    </style>
</head>
<body>

<h1>Feed / ${feed.id}</h1>

<form method="post" action="<%= request.getRequestURL() %>">
    <input type="hidden" name="id" value="${feed.id}"/>

    <table border="1" width="100%">
        <tr>
            <td width="20%">ID</td>
            <td width="80%">${feed.id}</td>
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
            <td><input name="icon_url" value="${feed.iconUrl}" /></td>
        </tr>
        <tr>
            <td>Logo URL</td>
            <td><input name="logo_url" value="${feed.logoUrl}" /></td>
        </tr>
        <tr>
            <td>Feed URL</td>
            <td><input name="feed_url" value="${feed.feedUrl}"/></td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input name="title" value="${feed.title}"/></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input name="author" value="${feed.author}"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input name="description" value="${feed.description}"/></td>
        </tr>
        <tr>
            <td>Job interval</td>
            <td><input name="job_interval" value="${feed.jobInterval}"/></td>
        </tr>
        <tr>
            <td>Next job</td>
            <td><input name="next_job" value="${feed.nextJob}"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="submit" value="Save"/></td>
        </tr>
    </table>
</form>

</body>
</html>
