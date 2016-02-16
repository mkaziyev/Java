<%--
  Created by IntelliJ IDEA.
  User: ww
  Date: 14.02.2016
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit User</h1>
<form method="post" action="addUser">
    Name: <input type="text" name="name"/>
    Age: <input type="text" name="age"/>
    Is Admin: <input type="checkbox" name="isAdmin" value="true" />
    <button>Add</button>
</form>
</body>
</html>
