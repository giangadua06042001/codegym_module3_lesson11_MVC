<%--
  Created by IntelliJ IDEA.
  User: LAPTOP CU PHO YEN
  Date: 5/17/2023
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new Customer</h1>
<p>
<c:if test='${requestScope["create"] != null}'>
    <span class="message">${requestScope["create"]}</span>
</c:if>
</p>
<p>
    <a href="/demo">Back to customer</a>
</p>
<form action="/customers?action=create" method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
