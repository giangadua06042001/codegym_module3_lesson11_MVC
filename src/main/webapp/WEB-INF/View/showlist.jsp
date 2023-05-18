<%--
  Created by IntelliJ IDEA.
  User: LAPTOP CU PHO YEN
  Date: 5/17/2023
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Product</h1>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
 <c:forEach items="${List}" var="products">
 <tr>
     <td><a href=`"/view?round=showlist=" + ${products.getId()}`></a></td>
     <td>${products.name}</td>
     <td>${products.price}</td>
     <td>Edit</td>
     <td>Delete</td>
 </tr>
 </c:forEach>
</table>

</body>
</html>
