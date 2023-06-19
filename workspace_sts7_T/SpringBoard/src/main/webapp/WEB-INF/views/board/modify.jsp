<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 이제 가능함. -->

<%@ include file="../include/header.jsp"%>
<h2>http://localhost:8088/board/regist 호출</h2>
<h1>regist.jsp</h1>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">ITWILL 글 수정하기</h3>
	</div>
	<!-- /board/regist (post) -->
	<form action="" method="" role="form" id="fr">
		<input type="hidden" name="bno" value="${vo.bno }">

	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">번호</label> <input type="text"
				class="form-control" id="exampleInputEmail1"
				placeholder="Enter title" name="bno" value="${vo.bno}">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">제목</label> <input type="text"
				class="form-control" id="exampleInputEmail1"
				placeholder="Enter title" name="title" value="${vo.title}">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">이름</label> <input type="text"
				class="form-control" id="exampleInputPassword1"
				placeholder="Enter name" name="writer" value="${vo.writer}">
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea class="form-control" rows="3" placeholder="Enter content"
				name="content">${vo.content }</textarea>
		</div>
	</div>

	</form>
	<div class="box-footer">
		<button type="submit" class="btn btn-success">수정하기</button>
		<button type="reset" class="btn btn-danger">취소하기</button>
	</div>

</div>

<script>
$(document).ready(function(){
	var formObj = $('#fr'); // 폼태그 안의 객체 정보를 저장(태그 말하는거임. <form action ..> : 요 안에 있는거 !)
	
	$('.btn-success').click(function(){
		// 수정하기 동작 수행 > modify 주소, post 방식!
		formObj.attr("method","post"); // method의 값을 post로 바꾼다.
		formObj.submit();
	});// click end

}); // jQ end

</script>


<%@ include file="../include/footer.jsp"%>


















































