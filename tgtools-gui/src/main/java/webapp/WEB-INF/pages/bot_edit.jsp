<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<c:set var="isNew" value="${bot.id == null ? true : false}"/>
<spring:message var="baseTitle" code="bot.page.title"/>
<spring:message var="addNewItem" code="bot.page.addNewItem" scope="request"/>
<spring:message var="title" text="${isNew ? addNewItem : bot.username} / ${baseTitle}" scope="request"/>

<spring:url var="linkSave" value="/bots/save/"/>
<spring:url var="linkList" value="/bots/"/>

<tg:wrapper>
    <jsp:attribute name="subnav">
        <a href="${linkList}"><spring:message code="bot.page.backToList"/></a>
    </jsp:attribute>

    <jsp:body>
        <tg:formWrapper model="bot" formAction="${linkSave}" cancelLink="${linkList}">
            <jsp:attribute name="hiddenFields">
                <form:hidden path="id"/>
                <form:hidden path="version"/>
            </jsp:attribute>
            <jsp:body>
                <tg:formInput field="userId" legendCode="bot.userId"/>
                <tg:formInput field="token" legendCode="bot.token"/>
                <tg:formInput field="username" legendCode="bot.username"/>
                <tg:formInput field="firstName" legendCode="bot.firstName"/>
                <tg:formInput field="lastName" legendCode="bot.lastName"/>
                <tg:formTextarea rows="3" field="about" legendCode="bot.about"/>
            </jsp:body>
        </tg:formWrapper>
    </jsp:body>
</tg:wrapper>
