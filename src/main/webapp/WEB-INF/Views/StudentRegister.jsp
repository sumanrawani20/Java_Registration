<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Student Registration Form</h1>
<form action="<%= request.getContextPath()%>" method="post">
    <table style="with:80%">
        <tr>
          <td> Name</td>
          <td><input type="text" name="Name"/></td>
        </tr>
        <tr>
            <td> Department</td>
            <td><input type="text" name="Department"/></td>
          </tr>
          <tr>
            <td> Email</td>
            <td><input type="text" name="Email"/></td>
          </tr>
          <tr>
            <td> Mobile</td>
            <td><input type="text" name="Mobile"/></td>
          </tr>
          <tr>
            <td> Address</td>
            <td><input type="text" name="Address"/></td>
          </tr>
    </table>
    <input type="submit" value="Submit"/>
</form>
</div>
</body>
</html>