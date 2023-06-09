<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login.jsp</h1>
<h2>http://localhost:8088/member/login</h2>

<fieldset>
	<form action="" method="post"> <!-- get으로 들어와서 post로 나감 !! action="" > 웹표준을 위해 존재. 없기도 함.-->
		ID: <input type="text" name="user_id"><br>
		PW: <input type="password" name="user_pw"><br>
		
		<input type="submit" value="login">
		<input type="button" value="sign in" onclick="location.href='/member/join'">
	</form>
</fieldset>

</body>
</html>