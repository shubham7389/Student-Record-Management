

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

@WebServlet("/DeleteStudentS")
public class DeleteStudentS extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		response.setContentType("text/html"); 
		String roll=request.getParameter("roll");		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","1435"); 
			String qr="delete from stud where roll=?";
			PreparedStatement ps=con.prepareStatement(qr); 
			ps.setString(1,roll);	
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("student successfully delete");
			}
			else
			{
				out.println("student not delete");
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println(e); 
		}
	}

}
