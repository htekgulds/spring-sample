<%--
  Created by IntelliJ IDEA.
  User: Hasan
  Date: 1.6.2015
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
  <h1><spring:message code="user.list" /></h1>
  <ul>
    <c:forEach items="${users}" var="user">
      <li>
        <c:out value="${user.id}"/>
      </li>
    </c:forEach>
  </ul>

  <a href="<spring:url value="/user_create.html" />"><spring:message code="user.create" /></a>
</body>
</html>
