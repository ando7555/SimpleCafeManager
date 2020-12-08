<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add product</title>
</head>
<body>
<div style="width: 30%">
    <h3>create product</h3>
    <c:if test="${message!=null}">
        <h4 style="color: green;">${message}</h4>
    </c:if>
    <form:form action="/product/admin/add" method="post" modelAttribute="product">
        <form:errors path="name" cssStyle="color: red"/> <br>
        <form:input path="name" placeholder="name"/> <br> <br>
        <form:errors path="price" cssStyle="color: red"/>
        <form:input path="price" placeholer="price" type="number"/>
        <input type="submit" value="create product">
    </form:form>
</div>
<a href="/manager.html">back to manager page</a>
</body>
</html>
