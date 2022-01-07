

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		response.setContentType("text/html");
		
		out.println("<h1 > Student All Data List</h1>"); 
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","1435");
		String qr="select * from stud";
		
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(qr); 
		if(rs.next())
		{
			out.println("<table align='center'border='4px'>");
			out.println("<th>Roll</th>");
			out.println("<th>NAME</th>");
			out.println("<th>EMAIL</th>");
			out.println("<th>MOBILE</th>");
			out.println("<th>BRANCH</th>");
			out.println("<th>SEMESTER</th>");
			
			do
			{
				String roll=rs.getString("roll");
				String name=rs.getString("name"); 
				String email=rs.getString("email"); 
				String mobile=rs.getString("mobile"); 
				String branch=rs.getString("branch"); 
				String sem=rs.getString("sem"); 
				
				out.println("<tr>");
					out.println("<td>");
					out.println(roll);
					out.println("</td>");
					
					out.println("<td>");
					out.println(name);
					out.println("</td>");

					out.println("<td>");
					out.println(email);
					out.println("</td>");

					out.println("<td>");
					out.println(mobile);
					out.println("</td>");
					
					out.println("<td>");
					out.println(branch);
					out.println("</td>");

					out.println("<td>");
					out.println(sem);
					out.println("</td>");
				out.println("</tr>");
			}
			while(rs.next());
		}
		else
		{
			System.out.println("no record found....!");
		}
		con.close();
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	}

}
