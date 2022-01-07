<%@page errorPage="ErrorPageForStudent" %>
<%@include file="DLC.jsp" %>
<%
	String roll=request.getParameter("roll");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile");
	String branch=request.getParameter("branch");
	String sem=request.getParameter("sem");
	
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
%>
