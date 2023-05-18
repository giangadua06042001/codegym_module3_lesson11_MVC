<%--
  Created by IntelliJ IDEA.
  User: LAPTOP CU PHO YEN
  Date: 5/17/2023
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer list</title>
    <style type="text/css">
       .item #Name{
            width: 40px;
            height: 10px;
        }
    </style>
</head>
<body>
<div class="item">
    <h1>Customers</h1>
    <p>
        <a href="/customers?action=create">Create new customer</a>
    </p>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>

        </tr>
        <c:forEach items='${list}' var="Customer">
            <tr>
                <td><a href="/customers?action=view&Id=${Customer.getId()}">${Customer.getName()}}</a></td>
                <td>${Customer.getEmail()}</td>
                <td>${Customer.getAddress()}</td>
                <td><a href="/customers?action=edit&Id=${Customer.getId()}">Edit</a></td>
                <td><a href="/customers?action=delete&Id=${Customer.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
