<%
	String id=request.getParameter("id"); 
	String pwd=request.getParameter("pwd");
	
	if(id.equals("student") && pwd.equals("1234"))
	{
		//session.setAttribute("id", id);
		response.sendRedirect("StudentHomePage.jsp"); 
	}
	else
	{
		out.println("Invalid id and password............!"); 
	}
%>