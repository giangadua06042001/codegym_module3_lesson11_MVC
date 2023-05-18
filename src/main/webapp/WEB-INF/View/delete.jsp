<%--
  Created by IntelliJ IDEA.
  User: LAPTOP CU PHO YEN
  Date: 5/18/2023
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  method="post" action="/customers?action=delete">
    <h3>Are  you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
      <table>
          <tr>
              <td>Name:</td>
              <td>${requestScope["newCustomer"].getName()}</td>
          </tr>
          <tr>
              <td>Email:</td>
              <td>${requestScope["newCustomer"].getEmail()}</td>
          </tr>
          <tr>
              <td>Address:</td>
              <td>${requestScope["newCustomer"].getAddress()}</td>
          </tr>
          <tr>
              <td><input type="submit" value="Delete customer"></td>
              <td><a href="/customers">Back to customer list</a></td>
          </tr>

      </table>



    </fieldset>
</form>

</body>
</html>
