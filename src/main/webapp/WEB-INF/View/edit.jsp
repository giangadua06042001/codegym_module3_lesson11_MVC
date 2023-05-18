<%--
  Created by IntelliJ IDEA.
  User: LAPTOP CU PHO YEN
  Date: 5/18/2023
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post" action="/customers?action=update">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Email:</td>
                <td>
                    <label><input type="text" name="name" id="name" value="${requestScope["newCustomer"].getName()}"></label>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <label><input type="text" name="email" id="email" value="${requestScope["newCustomer"].getEmail()}"></label>
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>
                    <label><input type="text" name="Address" id="Address" value="${requestScope["newCustomer"].getAddress()}"></label>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <label><input type="submit" value="Update customer"></label>
                </td>
            </tr>
        </table>
    </fieldset>

</form>

</body>
</html>
