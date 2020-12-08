<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>waiter page</title>
</head>
<body>
<h2>hello ${sessionScope.user.username}</h2>
<c:if test="${message!=null}">
    <h3 style="color: green;">${message}</h3>
</c:if>
<table border="1">
    <tr>
        <td>table number</td>
        <td>create order</td>
        <td>show table`s orders</td>
    </tr>
    <c:forEach items="${sessionScope.user.tables}" var="table">
        <tr>
            <td>${table.tableNumber}</td>
            <td><a href="/order/crate/${table.id}">create order</a></td>
            <td><a href="/table/showOrders/${table.id}">open table order</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/logout">logout</a>
</body>
</html>
