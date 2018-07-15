<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="title" value="PostId=${post.id}" scope="request"/>

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

    <table class="table_view">

        <tr>
            <td class="td_legend">Post ID</td>
            <td>${post.id}</td>
        </tr>
        <tr>
            <td class="td_legend">Feed</td>
            <td>${post.feed.id} ${post.feed.id} ${post.feed.id}</td>
        </tr>
        <tr>
            <td class="td_legend">Author</td>
            <td>${post.author}<c:if test="${post.authorUrl != null}"> - ${post.authorUrl}</c:if></td>
        </tr>
        <tr>
            <td class="td_legend">Post URL</td>
            <td>${post.postUrl}</td>
        </tr>
        <tr>
            <td class="td_legend">Post XID</td>
            <td>${post.postXid}</td>
        </tr>
        <tr>
            <td class="td_legend">Title</td>
            <td>${post.title}</td>
        </tr>
        <tr>
            <td class="td_legend">Content</td>
            <td><div class="post_content">${post.content}</div></td>
        </tr>

    </table>

</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
