<%-- <% 
	session.invalidate();
	response.sendRedirect("/mvc/member/main.do");
%> --%>
<%-- <%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>

<%-- <c:choose>
    <c:when test="${sessionScope.memId == null}">
    <!-- 로그인 부분 -->
        <div class="card">
            <h3>로그인</h3>
            <form method="post" action="${pageContext.request.contextPath}/member/loginPro.do">
                <input type="hidden" name="command" value="login">
                <p>아이디 <input type="text" name="Id" placeholder="아이디" size="12"></p>
                <p>패스워드 <input type="password" name="passwd" placeholder="비밀번호" size="12"></p>
                <input type="submit" value="로그인">
                <a href="${pageContext.request.contextPath}/member/inputForm.do?command=registerPage">회원가입</a></p>
            </form>
        </div>            
    </c:when>
    <c:otherwise>
        <div class="card">        
            <p>${sessionScope.clientDTO.clientName}님    반갑습니다.</p>
            <p><a href="${pageContext.request.contextPath}/member/modify.do?command=logout">로그아웃</a></p>
            <p><a href="#">회원수정</a></p>         
            <p><a href="#">회원탈퇴</a></p>
            <p><a href="${pageContext.request.contextPath}/member/main.do">홈으로</a>  </p>
        </div>
        <!-- 메뉴부분 -->
        <div class="card">
            <h3>게시판</h3>
            <a href="#">게시판 보기</a>  
        </div>
    </c:otherwise>
</c:choose> --%>

<%-- <c:if test="${sessionScope.memId == null}">
	<script>
	alert("정상적으로 로그아웃 되었습니다.");
	history.go(-1);
	</script>
	<c:redirect url="/member/main.do" />
</c:if> --%>
<script>
	window.location="/spring/member/main.do";
</script>
