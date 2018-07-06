<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="title" value="Posts" scope="request"/>

<!doctype html>
<html>
<jsp:include page="../include/metadata.jsp"/>
<body>

<jsp:include page="../include/header.jsp"/>

<nav class="subnav">
    <a href="<spring:url value='/feeds/'/>">Feeds</a>
</nav>

<main>

    <form:form>
        <div class="search">
            <div class="entity">
                <div class="legend"><spring:message text="Author"/></div>
                <div class="input"><form:input path=""/></div>
            </div>
            <div class="entity">
                <div class="legend"><spring:message text="Title"/></div>
                <div class="input"><form:input path="title"/></div>
            </div>
            <div class="entity">
                <div class="legend"><spring:message text="Content"/></div>
                <div class="input"><form:input path="content"/></div>
            </div>
            <div class="entity">
                <div class="button"><form:button>Search</form:button></div>
            </div>
        </div>
    </form:form>

    <table class="table_list">
        <tr>
            <th class="numeric"><spring:message text="ID"/></th>
            <th><spring:message text="Author"/></th>
            <th><spring:message text="Title"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${postList}" var="post">
            <tr>
                <td class="numeric">${post.id}</td>
                <td>${post.author}</td>
                <td>${post.title}</td>
                <td class="td_buttons"><a href="<spring:url value="/posts/view/${post.id}/"/>">view</a></td>
            </tr>
        </c:forEach>
    </table>

</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
