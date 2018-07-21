<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<c:set var="title" value="Telegram Channels" scope="request"/>

<tg:wrapper>
    <jsp:attribute name="subnav">
        <a href="<spring:url value='/channels/new/'/>">Add new channel</a>
    </jsp:attribute>
    <jsp:body>
        <table class="table_list">
            <tr>
                <th class="numeric"><spring:message text="ID"/></th>
                <th><spring:message text="Name"/></th>
                <th><spring:message text="Status"/></th>
                <th><spring:message text="Bot"/></th>
                <th><spring:message text="Feed"/></th>
                <th><spring:message text="Posts"/></th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${channels}" var="channel">
                <tr>
                    <td class="numeric">${channel.id}</td>
                    <td>${channel.name}</td>
                    <td>${channel.status}</td>
                    <td>${channel.bot.name}</td>
                    <td>${channel.feed.title}</td>
                    <td>8 / 300</td>
                    <td class="td_buttons">
                        <a href="<spring:url value="/channels/view/${channel.id}/"/>"><spring:message text="overview"/></a>
                        <a href="<spring:url value="/channels/edit/${channel.id}/"/>"><spring:message text="edit"/></a>
                        <a href="<spring:url value="/channels/delete/${channel.id}/"/>"><spring:message text="delete"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="/WEB-INF/pages/include/paginator.jsp"/>
    </jsp:body>
</tg:wrapper>
