<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<h1>listALL.jsp</h1>
<h1>http://localhost:8088/board/listALL</h1>
<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">Bordered Table</h3>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			var data = "${result}";

			if (data == "CREATEOK") {
				callModal("글쓰기 성공!");
			}// CRE if end
			if(data == "MODOK"){
				callModal("글 수정 성공!");
			}// MOD if end
			if(data == "DELOK"){
				callModal("글 삭제 성공!");
			}// MOD if end
				
			function callModal(txt){
				$(".modal-body").html(txt);
				$("#modal-info").modal("show");
			} // callModal() function end
			
		})// jQ end
	</script>

	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 60px">번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th style="width: 60px">조회수</th>
				</tr>
				<c:forEach var="vo" items="${boardList }">
					<tr>
						<td>${vo.bno }</td>
						<td><a href="/board/read?bno=${vo.bno}">${vo.title }</a></td>
						<td>${vo.writer }</td>
						<td>${vo.regdate }</td>
						<td><span class="badge bg-blue">${vo.viewcnt }</span></td>
					</tr>
				</c:forEach>
				<!-- 				<tr> -->
				<!-- 					<td>1.</td> -->
				<!-- 					<td>Update software</td> -->
				<!-- 					<td>3333</td> -->
				<!-- 					<td>3333</td> -->
				<!-- 					<td><span class="badge bg-red">55%</span></td> -->
				<!-- 				</tr> -->
			</tbody>
		</table>
	</div>
</div>
<!-- 모달창 -->
<button type="button" class="btn btn-info" data-toggle="modal"
	data-target="#modal-info">Launch Info Modal</button>
<div class="modal modal-info fade" id="modal-info"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">Info Modal</h4>
			</div>
			<div class="modal-body">
				<p>One fine body…</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-outline pull-left"
					data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- 모달창 -->

<%@ include file="../include/footer.jsp"%>


