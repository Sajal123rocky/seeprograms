<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","");
	int id=Integer.parseInt(request.getParameter("id"));
	int salary=Integer.parseInt(request.getParameter("salary"));
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	String project=request.getParameter("project");
	PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?,?)");
	ps.setInt(1,id);
	ps.setString(2,fname);
	ps.setString(3,lname);
	ps.setString(4,project);
	ps.setInt(5,salary);
	int i=ps.executeUpdate();
	if(i==1)
		out.println("data inserted successfully");
	else
		out.println("no data");
}
catch(Exception e)
{
	out.println(e.getMessage());
}
%>
</body>
</html>