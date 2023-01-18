

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
@WebServlet("/police")
public class police extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Police","root","");
			String opt=request.getParameter("opt");
			String str=request.getParameter("str");
			int c=0;
			if(opt.equals("area"))
			{
				PreparedStatement ps=con.prepareStatement("select * from pinfo where name=?");
				ps.setString(1, str);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					c=1;
					out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
				}
			}
			else if(opt.equals("num"))
			{
				int i=Integer.parseInt(str);
				PreparedStatement ps=con.prepareStatement("select * from pinfo where num=?");
				ps.setInt(1, i);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					c=1;
					out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
				}
			}
			if(c==0)
			{
				out.println("no data");
			}
		}
		catch(Exception e)
		{
			out.print("invalid input or no input");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
