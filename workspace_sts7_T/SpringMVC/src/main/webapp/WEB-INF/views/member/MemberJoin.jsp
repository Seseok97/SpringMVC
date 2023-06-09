<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MemberJoin.jsp</h1>
<h2>http://localhost:8088/member/join</h2>
<!-- 컨트롤러 분리로 인하여 별도 폴더 생성. -->
<fieldset>
	<form action="./join" method="post">
	<!-- action을 미입력 > 자신의 주소 호출!! >> 전달방식이 POST로 바뀜 > 동작이 수행됨. -->
		아이디: <input type="text" name="user_id"><br>
		비밀번호: <input type="password" name="user_pw"><br>
		이름: <input type="text" name="user_name"><br>
		이메일: <input type="text" name="user_email"><br>
		
		<input type="submit" value="회원가입">
	</form>
</fieldset>
</body>
</html>