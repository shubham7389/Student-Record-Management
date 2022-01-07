<%@page errorPage="ErrorPageForStudent.jsp" %>
<%@include file="DLC.jsp" %>
<%
	String roll=request.getParameter("roll"); 
	String name=request.getParameter("name"); 
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile"); 
	String branch=request.getParameter("branch"); 
	String sem=request.getParameter("sem"); 
	
	String qr="update stud set name=?, email=?, mobile=?, branch=?, sem=? where roll=? ";
	PreparedStatement ps=con.prepareStatement(qr); 
	ps.setString(1, name);
	ps.setString(2, email);
	ps.setString(3, mobile);
	ps.setString(4, branch);
	ps.setString(5, sem);
	ps.setString(6, roll);
	
	int i= ps.executeUpdate(); 
	if(i>0)
	{
		out.println("Student Data Update sucessfully"); 
	}
	else
	{
		out.println("Student data not update"); 
	}
	
%>