import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudentDataS")
public class UpdateStudentDataS extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		response.setContentType("text/html"); 
		String roll=request.getParameter("roll");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String branch=request.getParameter("branch");
		String sem=request.getParameter("sem");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","1435"); 
			String qr="update stud set name=?, email=?, mobile=?, branch=?, sem=? where roll=?";
			PreparedStatement ps=con.prepareStatement(qr); 
			ps.setString(6,roll); 
			ps.setString(1,name); 
			ps.setString(2,email);
			ps.setString(3,mobile);
			ps.setString(4,branch);
			ps.setString(5,sem);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("Student details successfully update");
			}
			else
			{
				out.println("student not update");
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println(e); 
		}
	}

}
