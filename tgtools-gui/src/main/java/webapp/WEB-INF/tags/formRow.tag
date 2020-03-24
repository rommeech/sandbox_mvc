<%@ tag pageEncoding="UTF-8" description="Edit field wrapper: input, legend, validation error" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="field" required="true" type="java.lang.String" %>
<%@ attribute name="legendCode" required="true" type="java.lang.String" %>
<%@ attribute name="cssClass" required="false" type="java.lang.String" %>

<div class="edit_row ${cssClass}">
    <div class="edit_legend"><spring:message code="${legendCode}"/></div>
    <div class="edit_input">
        <jsp:doBody/>
        <form:errors path="${field}" cssClass="field_error"/>
    </div>
</div>