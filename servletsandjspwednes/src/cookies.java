

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.http.*;
@WebServlet("/cookies")
public class cookies extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c1=new Cookie("n1","v1");
		Cookie c2=new Cookie("n2","v2");
		Cookie c3=new Cookie("n3","v3");
		Cookie c4=new Cookie("n4","v4");
		c1.setMaxAge(60);
		c2.setMaxAge(60);
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.addCookie(c4);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Cookie[] ck=request.getCookies();
		/*for(int i=0;i<ck.length;i++)
		{
			out.println("<br>"+ck[i].getName()+" "+ck[i].getValue());
		}*/
		//out.println("<br>"+ck[0].getName()+" "+ck[0].getValue());
		out.println("<br>"+ck[1].getName()+" "+ck[1].getValue());
		out.println("<br>"+ck[2].getName()+" "+ck[2].getValue());
		out.println("<br>"+ck[3].getName()+" "+ck[3].getValue());
		out.println("<br>"+ck[4].getName()+" "+ck[4].getValue());
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
