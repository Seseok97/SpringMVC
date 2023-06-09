<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>info.jsp</h1>
<h2>http://localhost:8088/member/info</h2>
<%-- ${resultVO } --%>
${memberVO } <!-- VO의 클래스명의 앞글자를 소문자로 변경한 것. 이 형태로도 많이 사용된다. -->

<hr>
<%-- 아이디:${resultVO.user_id } <br> --%>
<%-- 비밀번호:${resultVO.user_pw } <br> --%>
<%-- 이름:${resultVO.user_name } <br> --%>
<%-- 이메일:${resultVO.user_email } <br> --%>
<%-- 가입일:${resultVO.regdate } <br> --%>
<%-- 수정일:${resultVO.updatedate } <br> --%>

<h3>memberVO</h3>
아이디:${memberVO.user_id } <br>
비밀번호:${memberVO.user_pw } <br>
이름:${memberVO.user_name } <br>
이메일:${memberVO.user_email } <br>
가입일:${memberVO.regdate } <br>
수정일:${memberVO.updatedate } <br>

<a href="/member/main">메인으로</a>

</body>
</html>