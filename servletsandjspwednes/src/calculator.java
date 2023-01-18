

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@WebServlet("/calculator")
public class calculator extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try
		{
			String opt=request.getParameter("opt");
			int a=Integer.parseInt(request.getParameter("num1"));
			int b=Integer.parseInt(request.getParameter("num2"));
			switch(opt)
			{
			case "+":out.print(a+b); break;
			case "-":out.print(a-b); break;
			case "*":out.print(a*b); break;
			case "/":out.print(a/b); break;
			case "^":out.print(Math.exp(a)); break;
			}
		}
		catch(Exception e)
		{
			out.println("no input or divide by 0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
