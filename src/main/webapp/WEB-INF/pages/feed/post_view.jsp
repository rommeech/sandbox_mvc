<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="title" value="Post ID: ${post.id}" scope="request"/>

<!doctype html>
<html>
<jsp:include page="../include/metadata.jsp"/>
<body>

<jsp:include page="../include/header.jsp"/>

<nav class="subnav">
    <a href="<spring:url value='/feeds/'/>">Feeds</a>
    <a href="<spring:url value='/feeds/edit/${post.feed.id}/'/>">Posts feed</a>
    <a href="<spring:url value='/posts/?feed=${post.feed.id}'/>">Posts</a>
</nav>

<main>

    <table width="90%">
        <col width="20%">
        <col width="80%">
        <tr>
            <td>Post ID</td>
            <td>${post.id}</td>
        </tr>
        <tr>
            <td>Feed</td>
            <td>${post.feed.id} ${post.feed.id} ${post.feed.id}</td>
        </tr>
        <tr>
            <td>Author</td>
            <td>${post.author}<c:if test="${post.authorUrl != null}"> - ${post.authorUrl}</c:if></td>
        </tr>
        <tr>
            <td>Post URL</td>
            <td>${post.postUrl}</td>
        </tr>
        <tr>
            <td>Post XID</td>
            <td>${post.postXid}</td>
        </tr>
        <tr>
            <td>Title</td>
            <td>${post.title}</td>
        </tr>
        <tr>
            <td>Content</td>
            <td><div class="post_content">${post.content}</div></td>
        </tr>

    </table>

</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
