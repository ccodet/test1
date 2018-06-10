<%--
  Created by IntelliJ IDEA.
  User: Tong
  Date: 2018/6/4
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>haha</title>
</head>
<body>
<form action="/students/hello" method="post">
    姓名    <input type="text" name="sname">
    <br/>
    密码    <input type="text" name="pwd">
    <input type="submit" value="提交">
</form>
</body>
</html>
