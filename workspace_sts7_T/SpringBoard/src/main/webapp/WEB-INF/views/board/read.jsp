<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<h1>http://localhost:8088/board/read?bno=${vo.bno}</h1>
<h1>read.jsp</h1>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">ITWILL 게시판 내용</h3>
	</div>
		<!-- 수정/삭제, 정보전달용 > js,jquery로는 정보를 전달할 수 없기때문. -->
		<form role="form" id="fr">
			<input type="hidden" name="bno" value="${vo.bno }"> <!-- EL 표현식 뒤에 공백 없어야함 !! 값에 공백 들어갈수 있다 ! -->
		</form>

	<!-- /board/regist (post) -->
	<!-- 	<form role="form" method="post"> -->
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">번호</label> <input type="text"
				class="form-control" id="exampleInputEmail1"
				placeholder="Enter title" name="title" value="${vo.bno }" readonly>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">제목</label> <input type="text"
				class="form-control" id="exampleInputEmail1"
				placeholder="Enter title" name="title" value="${vo.title }" readonly>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">이름</label> <input type="text"
				class="form-control" id="exampleInputPassword1"
				placeholder="Enter name" name="writer" value="${vo.writer }"
				readonly>
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea class="form-control" rows="3" placeholder="Enter content"
				name="content" readonly>${vo.content }</textarea>
		</div>
	</div>

	<div class="box-footer">
		<button type="button" class="btn btn-info">수정하기</button>
		<button type="button" class="btn btn-danger">삭제하기</button>
		<button type="button" class="btn btn-success">목록으로</button>
	</div>
	<!-- 	</form> -->
</div>

<script>
	$(document).ready(function() {
		
		// 폼태그 객체
// 		$('#fr'); 				// id속성 탐색
		 var frObj = $("form[role='form']"); // 속성탐색 선택자
		
		$('.btn-info').click(function() { // 수정
// 			location.href = '/board/modify?bno=${vo.bno}';
			// 폼태그 사용시 bno를 가지고 수정페이지로 이동(GET).
			frObj.attr("action","/board/modify");
			frObj.submit();
		})// onclick end

		$('.btn-danger').click(function() { // 삭제
			frObj.attr("action","/board/remove");
			frObj.attr("method","post");
			frObj.submit();
		})// onclick end

		$('.btn-success').click(function() { // 목록
			location.href = '/board/listALL';
		})// onclick end
	});//jQ end
</script>

<%@ include file="../include/footer.jsp"%>