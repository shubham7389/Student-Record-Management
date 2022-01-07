<%@page errorPage="ErrorPageForStudent.jsp" %>
<%@include file="DLC.jsp" %>
<table align="center" border="1px">
	<tr>
		<th>Roll</th>
		<th>Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Branch</th>
		<th>Sem</th>
	</tr>
	
	<%
	String qr="select * from stud";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(qr); 
	if(rs.next())
	{
		do{
			String roll=rs.getString("roll");
			String name=rs.getString("name");
			String email=rs.getString("email");
			String mobile=rs.getString("mobile");
			String branch=rs.getString("branch");
			String sem=rs.getString("sem");
			
		%>
			<tr>
				<td><%=roll %></td>
				<td><%=name %></td>
				<td><%=email %></td>
				<td><%=mobile %></td>
				<td><%=branch %></td>
				<td><%=sem %></td>
			</tr>
		<%
		}while(rs.next());
	}
	else
	{
		out.println("no record found...........!"); 
	}
	con.close(); 
%>
</table>