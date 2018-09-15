<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<c:set var="isNew" value="${bot.id == null ? true : false}"/>
<c:set var="title" value="${isNew ? 'Add new' : bot.name} / Telegram bots" scope="request"/>

<spring:url var="linkSave" value="/bots/save/"/>
<spring:url var="linkList" value="/bots/"/>

<tg:wrapper>
    <jsp:attribute name="subnav">
        <a href="${linkList}"><spring:message code="bot.linkList"/></a>
    </jsp:attribute>

    <jsp:body>
        <tg:formWrapper model="bot" formAction="${linkSave}" cancelLink="${linkList}">
            <jsp:attribute name="hiddenFields">
                <form:hidden path="id"/>
                <form:hidden path="version"/>
            </jsp:attribute>
            <jsp:body>
                <tg:formInput field="name" legendCode="bot.name"/>
                <tg:formInput field="username" legendCode="bot.username"/>
                <tg:formInput field="token" legendCode="bot.token"/>
                <tg:formInput field="botpic" legendCode="bot.botpic"/>
                <tg:formTextarea rows="3" field="about" legendCode="bot.about"/>
                <tg:formTextarea rows="3" field="description" legendCode="bot.about"/>
            </jsp:body>
        </tg:formWrapper>
    </jsp:body>
</tg:wrapper>
