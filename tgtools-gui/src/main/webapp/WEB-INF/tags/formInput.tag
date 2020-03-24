<%@ tag pageEncoding="UTF-8" description="Edit field template: input, legend, validation error" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<%@ attribute name="id" required="false" type="java.lang.String" %>
<%@ attribute name="field" required="true" type="java.lang.String" %>
<%@ attribute name="legendCode" required="true" type="java.lang.String" %>
<%@ attribute name="readonly" required="false" type="java.lang.Boolean" %>
<%@ attribute name="cssClass" required="false" type="java.lang.String" %>

<tg:formRow field="${field}" legendCode="${legendCode}" cssClass="field_input">
    <jsp:body>
        <form:input path="${field}" readonly="${readonly}" id="${id}"
                    cssClass="${cssClass}" cssErrorClass="field_error" />
    </jsp:body>
</tg:formRow>
