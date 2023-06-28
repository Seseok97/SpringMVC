<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#btnAjax').on('click',function(){
		$.ajax({
// 			url:"${pageContext.request.contextPath}/test2?msg=20000", // 통신할 주소
			url:"${pageContext.request.contextPath}/test2",
			data:{msg:"30000"},
			success:function(data){
				alert('성공! > ' + data);
			}// success end
			,error:function(){
				alert('실패!');
			}// error end
		}); // ajax end
	})// btnAjax click end
	
	$('#btnAjax2').on('click',function(){
		// RestController에서 생성된 객체정보 가져오기 (test3 > MemberVO vo를 리턴하고 있다.(json으로 리턴하고있음!!))
		var obj = { 
				name : "admin", 
				tel:"999-9999-9999"
			};
		
		
		$.ajax({
			url:"${pageContext.request.contextPath}/test3",
			contentType : "application/json",
			data:JSON.stringify(obj),
			type:"post",
			success:function(obj){
				alert('성공!');
				console.log(obj); // alert 창에서는 나타내는 정보의 제한이 있기 때문에, console.log로 확인.
				$('body').append("<br> 이름 : "+obj.name+", 전화번호 : "+obj.tel);
			}// success end
			,error:function(){
				alert('실패!');
			}// error end
		}); // ajax end
	})// btnAjax2 click end
	
});// jQ end
</script>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>

<button id="btnAjax">Ajax 호출</button>
<button id="btnAjax2">Ajax 호출2</button>

</body>
</html>
