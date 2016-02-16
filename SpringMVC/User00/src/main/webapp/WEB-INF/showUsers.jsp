<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: m
  Date: 12/02/2016
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search users</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

<h1>Search users</h1>
<form class="tg" action="/searchUsers" method="post">
    <tr>
        <td>Enter User Name</td>
        <td><input name="name" type="text">
            <input value="Search" type="submit">
            <%--<input value="New User" onclick="javascript:go('saveContact.do');" type="button">--%>
        </td>
    </tr>
</form>
<%--<c:if test="${empty users}"></c:if>--%>
<%--<c:if test="${! empty users}">--%>
<%--<c:forEach var="user" items="${users}"></c:forEach></c:if>--%>

<table class="tg">
    <thead>
    <tr>
        <th>Id</th>
        <th>name</th>
        <th>Age</th>
        <th>isAdmin</th>
        <th>Date</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty users}"></c:if>
    <c:if test="${! empty users}">
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><c:out value="${user.admin}"/></td>
            <td><c:out value="${user.createdDate}"/></td>
            <td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </c:if>
    </tbody>
</table>

</body>
</html>
