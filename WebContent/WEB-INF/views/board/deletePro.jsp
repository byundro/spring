<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}"> 
	<meta http-equiv="Refresh" content="0;url=/study/board/list.do?pageNum=${pageNum}" >
</c:if>
<c:if test="${check==0}"> 
비밀번호가 다릅니다.
<br>
<a href="javascript:history.go(-1)">[글삭제 폼으로 돌아가기]</a>
</c:if>