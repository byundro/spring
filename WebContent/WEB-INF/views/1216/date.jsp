<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>

	window.setInterval('date()' , 1000);   // date() 를 1초에 한번씩 호출한다. 
	
	function date(){
		$.ajax({
			 url:"time2.do",
			 type:"post",
			 success : function(result){  // result = time.do 실행된 결과 
				 $("#d").text(result);
			 }
		});
	}
</script>

<h1>date .. 페이지</h1>
<h1 id="d"></h1>