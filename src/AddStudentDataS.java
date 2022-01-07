

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

@WebServlet("/AddStudentDataS")
public class AddStudentDataS extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String qr="insert into stud values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr); 
			ps.setString(1,roll); 
			ps.setString(2,name); 
			ps.setString(3,email);
			ps.setString(4,mobile);
			ps.setString(5,branch);
			ps.setString(6,sem);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("Student details successfully added");
			}
			else
			{
				out.println("student not added");
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println(e); 
		}
	}

}
