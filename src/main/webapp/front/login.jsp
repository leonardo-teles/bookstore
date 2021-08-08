<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Evergreeen Books - Login</title>
	</head>
	
	<body>
	
		<jsp:include page="header.jsp"></jsp:include>
			
		<div align="center">
			<h3>Please, login</h3>
			
			<form>
				e-Mail: <input type="text" size="10"> <br/>
				password: <input type="password" size="10"> <br/>
				<input type="submit" value="login">
			</form>
		</div>
	
		<jsp:include page="footer.jsp"></jsp:include>
	
	</body>
</html>