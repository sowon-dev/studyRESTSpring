<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 제이쿼리 라이브러리추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//alert("제이쿼리 테스트")

	//뷰에서 버튼 클릭시, 전달한 데이터를 JSON형태로 생성 후 전송 -> ajax 비동기방식사용하여 RestController로 이동 -> RestController안에서 정보를 전달받아서 표시
	$('#checkJsonBtn').click(function(){
		//1.JSON형태로 데이터 생성
		let member = {num: "777", name: "사용자1", tel: "010-777-7777"};
		//2.데이터를 ajax 비동기방식으로 전송
		$.ajax({
			type:"post",
			url:"${contextPath}/test/info", //contextPath는  컨크롤러의 시작지점(/)을 의미
			contentType: "application/json",
			data: JSON.stringify(member), //member변수로 만든 객체를 문자열로 바꿔서 보낸다는 의미
			success:function(){
				 alert("ajax 이동 성공")
				},
			error:function(){
				 alert("ajax 이동 실패")
				},
			complete:function(){
				alert("ajax complete 항상 실행(이건 성공/실패 유무와 상관없이 항상 실행됨)")
				}
			});
	});
});
</script>
</head>
<body>
<h1>JSONtest.jsp</h1>
일반컨트롤러(HomeController)로 접속 후 input태그 사용<br>
<input type="button" id="checkJsonBtn" value="회원정보전송">
</body>
</html>