<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 코드를 합치는 인클루드 이기에 jstl선언후에 인클루드한다. --%>
<c:if test="${check == 1}">
	<c:redirect url="/member/main.do" />
</c:if>
<c:if test="${check == 0}">
		<script>
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
		</script>
</c:if>
<c:if test="${check == -1}">
		<script>
		alert("아이디를 체크해 주세요.");
		history.go(-1);
		</script>
</c:if>		