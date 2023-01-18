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
int m1=Integer.parseInt(request.getParameter("m1"));
int m2=Integer.parseInt(request.getParameter("m2"));
int m3=Integer.parseInt(request.getParameter("m3"));
int m4=Integer.parseInt(request.getParameter("m4"));
int m5=Integer.parseInt(request.getParameter("m5"));
int[] m=new int[5];
m[0]=m1;
m[1]=m2;
m[2]=m3;
m[3]=m4;
m[4]=m5;
String[] g=new String[5];
for(int i=0;i<5;i++)
{
	if(m[i]>=90)
		g[i]="S";
	else if(m[i]>=80&&m[i]<90)
		g[i]="A";
	else
		g[i]="f";
	
		
}
for(int i=0;i<g.length;i++)
{
	out.println("<br>"+"in subject "+(i+1)+" marks is "+m[i]+" grade is "+g[i]);
}
%>
</body>
</html>