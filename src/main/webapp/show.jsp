<%@page import="com.model.FormModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Show Page</h1>
	<%
	ArrayList<FormModel> data = (ArrayList<FormModel>) request.getAttribute("data");
	/* 	out.println(data); */
	%>


	<table border="2px">
		<tr>
			<th>Serial No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Mobile</th>
			<th>Image</th>
		</tr>


		<%
		for (int i = 0; i < data.size(); i++) {
		%>
		<tr>
			<td><%=data.get(i).getSno()%></td>
			<td><%=data.get(i).getName()%></td>
			<td><%=data.get(i).getEmail()%></td>
			<td><%=data.get(i).getPassword()%></td>
			<td><%=data.get(i).getMobile()%></td>
			<td><%=data.get(i).getFile_name()%></td>

		</tr>

		<%
		}
		%>
	</table>










</body>
</html>