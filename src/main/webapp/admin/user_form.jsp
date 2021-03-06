<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Create New User</title>
	</head>
	
	<body>
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<div align="center">
			<h2>Create New User</h2>
		</div>
		
		<div align="center">
			<form action="create_user" method="post" onsubmit="return validateFormInput()">
				<table>
					<tr>
						<td align="right">e-Mail:</td>
						<td align="left"> <input type="text" id="email" name="email" size="20"/> </td>
					</tr>
					<tr>
						<td align="right">Full Name:</td>
						<td align="left"> <input type="text" id="fullName" name="fullName" size="20"/> </td>
					</tr>
					<tr>
						<td align="right">Password:</td>
						<td align="left"> <input type="password" id="password" name="password" size="20"/> </td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="Save"/>
							<input type="button" value="Cancel" onclick="javascript:history.go(-1);"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
						
		<jsp:include page="footer.jsp"></jsp:include>
		
	</body>
	
	<script type="text/javascript">
		function validateFormInput() {
			var fieldEmail = document.getElementById("email");
			var fieldFullName = document.getElementById("fullName");
			var fieldPassword = document.getElementById("password");
			
			if(fieldEmail.value.length == 0) {
				alert("e-Mail is required");
				fieldEmail.focus();
				
				return false;
			}
			
			if(fieldFullName.value.length == 0) {
				alert("Full Name is required");
				fieldFullName.focus();
				
				return false;
			}
			
			if(fieldPassword.value.length == 0) {
				alert("Password is required");
				fieldPassword.focus();
				
				return false;
			}
			
			return true;
		}
	</script>
</html>