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
	/*int salary=Integer.parseInt(request.getParameter("salary"));
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
		out.println("no data");*/
	PreparedStatement ps=con.prepareStatement("select * from emp where id=?");
	ps.setInt(1,id);
	ResultSet rs=ps.executeQuery();
	int c=0;
	while(rs.next())
	{
		c=1;
		out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
	}
	if(c==0)
		out.println("no such data");
}
catch(Exception e)
{
	out.println("invaild or no date");
}
%>
</body>
</html>