<%@ tag pageEncoding="UTF-8" description="Edit field template: input, legend, validation error" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<%@ attribute name="id" required="false" type="java.lang.String" %>
<%@ attribute name="field" required="true" type="java.lang.String" %>
<%@ attribute name="legendCode" required="true" type="java.lang.String" %>
<%@ attribute name="readonly" required="false" type="java.lang.Boolean" %>
<%@ attribute name="cssClass" required="false" type="java.lang.String" %>
<%@ attribute name="items" required="true" type="java.util.List" %>
<%@ attribute name="itemValue" required="false" type="java.lang.String" %>
<%@ attribute name="itemLabel" required="false" type="java.lang.String" %>
<%@ attribute name="optional" required="false" type="java.lang.Boolean" %>


<tg:formRow field="${field}" legendCode="${legendCode}" cssClass="field_select">
    <jsp:body>
        <form:select path="${field}" id="${id}" cssClass="${cssClass}" cssErrorClass="field_error">
            <c:if test="${optional}"><form:option value="--- Select ---"/></c:if>
            <form:options path="${field}" items="${items}" itemValue="${itemValue}" itemLabel="${itemLabel}" />
        </form:select>
    </jsp:body>
</tg:formRow>