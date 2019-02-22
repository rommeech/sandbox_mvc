<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<spring:message var="title" code="feed.page.title" scope="request"/>

<tg:wrapper>

    <jsp:attribute name="subnav">
        <a href="<spring:url value='/feeds/new/'/>"><spring:message code="feed.page.addNewItem"/></a>
    </jsp:attribute>

    <jsp:body>
        <table class="table_list">
            <tr>
                <th class="numeric"><spring:message code="feed.id"/></th>
                <th><spring:message code="feed.status"/></th>
                <th><spring:message code="feed.title"/></th>
                <th></th>
                <th><spring:message code="feed.feedUrl"/></th>
                <th class="numeric"><spring:message code="feed.jobInterval"/></th>
                <th class="numeric"><spring:message code="feed.lastUpdated"/></th>
                <th class="numeric"><spring:message code="feed.nextJob"/></th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${feeds}" var="feed">
                <tr>
                    <td class="numeric">${feed.id}</td>
                    <td>${feed.status}</td>
                    <td>${feed.title}</td>
                    <td class="image"><img src="${feed.logoUrl}" /></td>
                    <td>${feed.feedUrl}</td>
                    <td class="numeric">${feed.jobInterval}</td>
                    <td class="numeric"><fmt:formatDate type="both" value="${feed.lastUpdated}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                    <td class="numeric"><fmt:formatDate type="both" value="${feed.nextJob}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                    <td class="td_buttons">
                        <a href="<spring:url value="/feeds/delete/${feed.id}/"/>"><spring:message code="action.delete"/></a>
                        <a href="<spring:url value="/feeds/edit/${feed.id}/"/>"><spring:message code="action.edit"/></a>
                        <a href="<spring:url value="/feeds/posts/?feedId=${feed.id}"/>"><spring:message code="action.posts"/></a>
                        <a href="<spring:url value="/feeds/read/${feed.id}/"/>"><spring:message code="action.read"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>

</tg:wrapper>

