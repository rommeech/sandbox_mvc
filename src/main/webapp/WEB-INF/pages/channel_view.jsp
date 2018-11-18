<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<spring:message var="baseTitle" code="channel.page.title" scope="request"/>
<spring:message var="title" text="${channel.name} / ${baseTitle}" scope="request"/>

<spring:url var="linkList" value="/channels/"/>
<spring:url var="linkEdit" value="/channels/edit/${channel.id}/"/>
<spring:url var="linkNew"  value="/channels/new/"/>

<tg:wrapper>

    <jsp:attribute name="subnav">
        <a href="${linkList}"><spring:message code="channel.menu.back"/></a>
        <a href="${linkEdit}"><spring:message code="channel.menu.edit"/></a>
        <a href="${linkNew}"><spring:message code="channel.menu.add"/></a>
    </jsp:attribute>

    <jsp:body>
        <h2><spring:message code="channel.page.overview"/></h2>

        <div class="view_layer">
            <div class="view_row">
                <div class="view_legend"><spring:message code="channel.id"/></div>
                <div class="view_data">${channel.id}</div>
            </div>

            <div class="view_row">
                <div class="view_legend"><spring:message code="channel.name"/></div>
                <div class="view_data">${channel.name}</div>
            </div>

            <div class="view_row">
                <div class="view_legend"><spring:message code="channel.username"/></div>
                <div class="view_data">${channel.username}</div>
            </div>
        </div>

        <p>&nbsp;</p>
        <h2><spring:message code="channel.page.notPubPosts"/></h2>
        <table class="table_list">
            <tr>
                <th class="numeric"><spring:message code="channel.post.id"/></th>
                <th class="numeric"><spring:message code="channel.post.date"/></th>
                <th><spring:message code="channel.post.info"/></th>
            </tr>
            <c:forEach items="${unpublishedPosts}" var="post">
                <tr>
                    <td class="numeric">${post.id}</td>
                    <td>${post.pubDate}</td>
                    <td>${post.title}</td>
                </tr>
            </c:forEach>
        </table>

        <p>&nbsp;</p>
        <h2><spring:message code="channel.page.pubPosts"/></h2>
        <table class="table_list">
            <tr>
                <th class="numeric"><spring:message code="channel.post.id"/></th>
                <th class="numeric"><spring:message code="channel.post.date"/></th>
                <th><spring:message code="channel.post.info"/></th>
                <th><spring:message code="channel.post.request"/></th>
                <th><spring:message code="channel.post.response"/></th>
            </tr>
            <c:forEach items="${publishedPosts}" var="publication">
                <tr>
                    <td class="numeric">${publication.post.id}</td>
                    <td>${publication.dateCreated}</td>
                    <td>${publication.post.title}</td>
                    <td class="word_break">${publication.request}</td>
                    <td class="word_break">${publication.response}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>

</tg:wrapper>
