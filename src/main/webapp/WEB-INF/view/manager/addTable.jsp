<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Table</title>
</head>
<body>
<div style="width: 30%">
    <h3>create tables</h3>
    <c:if test="${message!=null}">
        <h4 style="color: green;">${message}</h4>
    </c:if>
    <form:form action="/table/admin/create" method="post" modelAttribute="table">
        <form:errors path="tableType" cssStyle="color: red"/> <br>
        <form:input path="tableType" type="number" placeholder="number of table"/> <br> <br>
        <input type="submit" value="create table">
    </form:form>
</div>
<a href="/manager.html">back to manager page</a>
</body>
</html>
