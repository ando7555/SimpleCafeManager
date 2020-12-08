<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>

        <td>product</td>
        <td>price</td>
        <td>amount</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.title}</td>
            <td>${product.price}</td>
            <td>
                <form action="/productInOrder/add" method="post">
                    <input type="hidden" name="productId" value="${product.id}">
                    <input type="hidden" name="orderId" value="${order.id}">
                    <input type="number" name="amount" placeholder="amount" required>
                    <input type="submit" value="add product into order">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/table/showOrders/${order.table.id}">back to orders list</a>
</body>
</html>
