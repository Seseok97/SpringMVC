<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이제 가능함. -->

<%@ include file="../include/header.jsp" %>
<h2>http://localhost:8088/board/regist 호출</h2>
<h1>regist.jsp</h1>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">ITWILL 글쓰기</h3>
	</div>

	<!-- /board/regist (post) -->
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제목</label> 
				<input
					type="text" class="form-control" id="exampleInputEmail1"
					placeholder="Enter title" name="title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">이름</label> 
				<input
					type="text" class="form-control" id="exampleInputPassword1"
					placeholder="Enter name" name="writer">
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label for="exampleInputFile">File input</label>  -->
<!-- 				<input type="file" -->
<!-- 					id="exampleInputFile"> -->
<!-- 				<p class="help-block">Example block-level help text here.</p> -->
<!-- 			</div> -->
<!-- 			<div class="checkbox"> -->
<!-- 				<label> <input type="checkbox"> Check me out -->
<!-- 				</label> -->
<!-- 			</div> --> 
				<!-- 날리려거든 div를 잘 보고, 안에 있는걸 div태그까지 포함해서 한번에 날려야 한다!! -->
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" rows="3" placeholder="Enter content" name="content"></textarea>
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-success">글 올리기</button>
		</div>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>
