

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentLoginS")
public class StudentLoginS extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd"); 
		if(id.equals("student")&&pwd.equals("1234"))
		{
			response.sendRedirect("StudentHomePage.html");
		}
		else
		{
			out.print("invalid id or password...!");
		}
	}

}
