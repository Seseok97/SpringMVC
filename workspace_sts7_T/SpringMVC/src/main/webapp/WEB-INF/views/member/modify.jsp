<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>modify.jsp</h1>
<h2>http://localhost:8088/member/modify</h2>
<!-- 컨트롤러 분리로 인하여 별도 폴더 생성. -->
<fieldset>
	<form action="" method="post">
		아이디: <input type="text" name="user_id" value="${memberVO.user_id }" readonly><br>
		비밀번호: <input type="password" name="user_pw" placeholder="input pw"><br>
		이름: <input type="text" name="user_name" value="${memberVO.user_name }"><br>
		이메일: <input type="text" name="user_email" value="${memberVO.user_email }"><br>
		
		<input type="submit" value="회원수정">
		<input type="button" value="메인으로" onclick="location.href='./main'">
	</form>
</fieldset>
</body>
</html>