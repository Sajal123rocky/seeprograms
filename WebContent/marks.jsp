<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String[] str=request.getParameter("marks").split(",");
int sum=0;
for(int i=0;i<str.length;i++)
	sum=sum+Integer.parseInt(str[i]);
double avg=(double)sum/5;
if(avg>=90)
	out.println("S");
else if(avg<90&&avg>=80)
	out.println("A");
else
	out.println("pass");
%>
</body>
</html>