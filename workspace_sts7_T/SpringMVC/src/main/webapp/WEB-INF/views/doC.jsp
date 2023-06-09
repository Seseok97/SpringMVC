<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>doC</h1>
EL표현식 (param.msg): ${param.msg }<hr> <!-- get방식으로 전달받은 파라미터 -->
EL표현식 (msg): ${msg } <!-- ModelAttribute로 인하여 가능해졌다 !! -->

<hr>

${age} 

<hr>
${vo }@<hr>
${user_id }@<hr>
${user_pw }@<hr>

${memberVO }@<hr>
<!-- MemberVO 객체의 경우, @ModelAttribute("이름")이 생략되어있다. -->
<!-- 이름이 없는 경우, 전달되는 데이터 타입의 첫글자를 소문자로 변경한 이름을 사용한다 !! -->

${tel }@<hr>
</body>
</html>