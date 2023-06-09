<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>delete.jsp</h1>
<h2>http://localhost:8088/member/delete.jsp</h2>

<fieldset>
	<form action="" method="post">
		PW: <input type="password" name="user_pw"><br>
		
		<input type="submit" value="delete">
		<input type="button" value="main" onclick="location.href='/member/main'">
	</form>
</fieldset>

</body>
</html>