<%--
  Created by
  User: Hasan TEKGÜL
  Date: 6/2/2015
  Time: 10:58 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1><spring:message code="user.create" /></h1>
    <a href="<spring:url value="/user_list.html" />"><spring:message code="user.list" /></a>

    <form:form method="POST" action="/user_create.html" modelAttribute="form">
        <form:errors path="" element="div" />
        <div>
            <form:label path="id"><spring:message code="user.id" /></form:label>
            <form:input path="id" />
            <form:errors path="id" />
        </div>
        <div>
            <form:label path="password1"><spring:message code="user.password1" /></form:label>
            <form:input path="password1" />
            <form:errors path="password1" />
        </div>
        <div>
            <form:label path="password2"><spring:message code="user.password2" /></form:label>
            <form:input path="password2" />
            <form:errors path="password2" />
        </div>
        <div>
            <input type="submit" />
        </div>
    </form:form>
</body>
</html>
