<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<c:set var="isNew" value="${channel.id == null ? true : false}"/>
<c:set var="title" value="${isNew ? 'Add New' : channel.name} / Telegram channels" scope="request"/>

<spring:url var="linkSave" value="/channels/save/"/>
<spring:url var="linkList" value="/channels/"/>

<tg:wrapper>
    <jsp:attribute name="subnav">
        <a href="${linkList}">Back to Channel List</a>
    </jsp:attribute>

    <jsp:body>
        <tg:formWrapper model="channel" formAction="${linkSave}" cancelLink="${linkList}">
            <jsp:attribute name="hiddenFields">
                <form:hidden path="id"/>
                <form:hidden path="version"/>
            </jsp:attribute>
            <jsp:body>
                <tg:formInput field="name" legendCode="channel.name"/>
                <tg:formInput field="token" legendCode="channel.token"/>
                <tg:formRadioButtons items="${statuses}" legendCode="channel.status" field="status" />
                <tg:formSelect items="${feeds}" field="feed.id" legendCode="channel.feed" itemValue="id" itemLabel="title"/>
                <tg:formSelect items="${bots}" field="bot.id" legendCode="channel.bot" itemValue="id" itemLabel="name"/>
            </jsp:body>
        </tg:formWrapper>
    </jsp:body>
</tg:wrapper>
