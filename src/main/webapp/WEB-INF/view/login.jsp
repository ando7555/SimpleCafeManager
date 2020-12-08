<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN PAGE</title>
</head>
<body>
<h3>${message}</h3>
<form action="/login" method="post">
    <input type="text" name="username" placeholder="user name"><br> <br>
    <input type="password" name="password" placeholder="password"> <br> <br>
    <input type="submit" value="log in">
</form>
</body>
</html>
