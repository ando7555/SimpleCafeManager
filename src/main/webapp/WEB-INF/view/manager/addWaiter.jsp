<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add waiter</title>
</head>
<body>
<div style="width: 30%">
    <h3>create user</h3>
    <c:if test="${message!=null}">
        <h4 style="color: green;">${message}</h4>
    </c:if>
    <form:form action="/user/add" method="post" modelAttribute="user">
        <form:errors path="username" cssStyle="color: red"/>
        <form:input path="username" placeholder="username"/> <br> <br>
        <form:errors path="password" cssStyle="color: red"/>
        <form:password path="password" placeholder="username"/> <br> <br>
        <input type="submit" value="add user">
    </form:form>

</div>
<a href="/manager.html">back to manager page</a>
</body>
</html>
