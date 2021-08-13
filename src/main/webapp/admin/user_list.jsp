<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Manage Users - Evergreen Bookstore Administration</title>
	</head>
	
	<body>
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<div align="center">
			<h2>Users Management</h2>
			<h3> <a href="user_form.jsp">Create New User</a> </h3>
		</div>
		
		<div align="center">
			<table border="1" cellpadding="5">
				<tr>
					<th>ID</th>
					<th>e-Mail</th>
					<th>Full Name</th>
					<th>Actions</th>
				</tr>
				
				<c:forEach var="user" items="${listUsers}">
					<tr>
						<td>${user.userId}</td>
						<td>${user.email}</td>
						<td>${user.fullName}</td>
						<td>
							<a href="">Edit</a> &nbsp;
							<a href="">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
		
	</body>
</html>