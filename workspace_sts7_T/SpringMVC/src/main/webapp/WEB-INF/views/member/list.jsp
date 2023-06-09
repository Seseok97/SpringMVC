<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>list.jsp</h1>
<h2>http://localhost:8088/member/list</h2>

<table border="1">
	<tr>
		<td>id</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일</td>
	</tr>
	<c:forEach var="vo" items="${memberList}">
	<tr>
		<td>${vo.user_id}</td>
		<td>${vo.user_name }</td>
		<td>${vo.user_email }</td>
		<td>${vo.regdate }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>