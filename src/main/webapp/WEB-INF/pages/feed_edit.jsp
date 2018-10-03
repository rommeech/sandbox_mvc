<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<c:set var="isNew" value="${feed.id == null ? true : false}"/>
<spring:message var="baseTitle" code="feed.title"/>
<spring:message var="addNewItem" code="feed.page.addNewItem" scope="request"/>
<spring:message var="title" text="${isNew ? addNewItem : feed.title} / ${baseTitle}" scope="request"/>

<spring:url var="linkSave" value="/feeds/save/"/>
<spring:url var="linkList" value="/feeds/"/>

<tg:wrapper>

    <jsp:attribute name="subnav">
        <a href="<spring:url value='/feeds/'/>"><spring:message code="feed.page.backToList"/></a>
    </jsp:attribute>

    <jsp:body>
        <tg:formWrapper model="feed" formAction="${linkSave}" cancelLink="${linkList}">

            <jsp:attribute name="hiddenFields">
                <form:hidden path="id"/>
                <form:hidden path="version"/>
            </jsp:attribute>

            <jsp:body>
                <tg:formSelect field="status" legendCode="feed.status" items="${statusList}"/>
                <tg:formInput field="title" legendCode="feed.title"/>
                <tg:formInput field="feedUrl" legendCode="feed.feedUrl"/>
                <tg:formInput field="jobInterval" legendCode="feed.jobInterval" cssClass="small"/>
                <tg:formInput field="nextJob" legendCode="feed.nextJob" cssClass="medium"/>
                <tg:formInput field="author" legendCode="feed.author" cssClass="medium"/>
                <tg:formInput field="logoUrl" legendCode="feed.logoUrl"/>
                <tg:formInput field="iconUrl" legendCode="feed.iconUrl"/>
                <tg:formTextarea rows="3" field="description" legendCode="feed.description"/>
            </jsp:body>

        </tg:formWrapper>
    </jsp:body>

</tg:wrapper>
