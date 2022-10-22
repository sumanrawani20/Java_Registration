<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
	String sql = "select * from student_details";
	PreparedStatement pstmt = conn.prepareStatement (sql);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()==false){
		out.println("No records found in table");
	}else
	{%>
	<table border="1">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Department</th>
    <th>Email</th>
    <th>Mobile</th>
    <th>Address</th>
  </tr>
  <%
  do{
  %>
    <tr>
      <td><%= rs.getString(1)%></td>
      <td><%= rs.getString(2)%></td>
      <td><%= rs.getString(3)%></td>
      <td><%= rs.getString(4)%></td>
      <td><%= rs.getString(5)%></td>
      <td><%= rs.getString(6)%></td>
    </tr>
  <%}
  while(rs.next());
  %>
</table>
		
	<%}
}catch(Exception e){
	e.getStackTrace();
}

%>
</body>
</html>