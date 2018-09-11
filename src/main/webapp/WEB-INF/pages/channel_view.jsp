<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<c:set var="title" value="${channel.name} / Telegram Channels" scope="request"/>

<spring:url var="linkList" value="/channels/"/>
<spring:url var="linkEdit" value="/channels/edit/${channel.id}/"/>
<spring:url var="linkNew"  value="/channels/new/"/>

<tg:wrapper>
    <jsp:attribute name="subnav">
        <a href="${linkList}">Back to channel list</a>
        <a href="${linkEdit}">Edit channel</a>
        <a href="${linkNew}">Add new channel</a>
    </jsp:attribute>

    <jsp:body>
        <h2>Overview</h2>
        <p>Id: ${channel.id}
            <br>Name: ${channel.name}
            <br>Token: ${channel.token}
            <br>Feed: ${channel.feed.title}
            <br>Bot: ${channel.bot.name}</p>

        <h2>Unpublished posts</h2>
        <c:forEach items="${unpublishedPosts}" var="post">
            ${post.id}<br>
        </c:forEach>

        <h2>Published posts</h2>
        <table class="table_list">
            <tr>
                <th class="numeric"><spring:message text="ID"/></th>
                <th class="numeric"><spring:message text="Pub Date"/></th>
                <th><spring:message text="Post"/></th>
                <th><spring:message text="Request"/></th>
                <th><spring:message text="Response"/></th>
            </tr>
            <c:forEach items="${publications}" var="publication">
                <tr>
                    <td class="numeric">${publication.id}</td>
                    <td>${publication.dateCreated}</td>
                    <td>${publication.post.title}</td>
                    <td class="word_break">${publication.request}</td>
                    <td class="word_break">${publication.response}</td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>
</tg:wrapper>
