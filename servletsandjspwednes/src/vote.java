

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/vote")
public class vote extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String[] dob=request.getParameter("dob").split("-");
		LocalDate da=LocalDate.now(); 
		String str=da.toString();
		String[] today=str.split("-");
		char c=name.charAt(0);
		boolean flag=true;
		for(int i=0;i<name.length();i++)
		{
			c=name.charAt(i);
			if(c=='@'||c=='*'||Character.isDigit(c))
			{
				flag=false;
				break;
			}
		}
		if(flag==false)
			out.println("invaild name");
		else
		{
			int year=Math.abs(Integer.parseInt(dob[0])-Integer.parseInt(today[0]));
			int month=Math.abs(Integer.parseInt(dob[1])-Integer.parseInt(today[1]));
			int day=Math.abs(Integer.parseInt(dob[2])-Integer.parseInt(today[2]));
			double res=year+(double)month/12+(double)day/365;
			if(res>18)
				out.println(name+" is eligible for vote and mail is "+mail);
			else
			out.println(name+" is not eligible for vote and mail is "+mail);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
