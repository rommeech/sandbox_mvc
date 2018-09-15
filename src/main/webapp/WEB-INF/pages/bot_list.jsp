<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<spring:message var="title" code="bot.title" scope="request"/>

<tg:wrapper>
    <jsp:attribute name="subnav">
        <a href="<spring:url value='/bots/new/'/>"><spring:message code="bot.addList"/></a>
    </jsp:attribute>
    <jsp:body>
        <table class="table_list">
            <tr>
                <th class="numeric"><spring:message code="bot.id"/></th>
                <th><spring:message code="bot.name"/></th>
                <th><spring:message code="bot.username"/></th>
                <th><spring:message code="bot.token"/></th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${bots}" var="bot">
                <tr>
                    <td class="numeric">${bot.id}</td>
                    <td>${bot.name}</td>
                    <td>${bot.username}</td>
                    <td>${bot.token}</td>
                    <td class="td_buttons">
                        <a href="<spring:url value="/bots/delete/${bot.id}/"/>"><spring:message code="action.delete"/></a>
                        <a href="<spring:url value="/bots/edit/${bot.id}/"/>"><spring:message code="action.edit"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="/WEB-INF/pages/include/paginator.jsp"/>
    </jsp:body>
</tg:wrapper>
