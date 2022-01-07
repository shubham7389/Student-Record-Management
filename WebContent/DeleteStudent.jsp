<%@page errorPage="ErrorPageForStudent" %>
<%@include file="DLC.jsp" %>
<% 	
	String roll=request.getParameter("roll");
	String qr="delete from stud where roll=?";
	PreparedStatement ps=con.prepareStatement(qr); 
	ps.setString(1, roll); 
	int i=ps.executeUpdate(); 
	
	if(i>0)
	{
			out.println("Student delete sucessfully"); 
	}
	else
	{
		out.println("student not delete");
	}
%>