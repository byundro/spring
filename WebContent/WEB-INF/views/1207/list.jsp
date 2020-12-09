<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach var="dto" items="${list}">
	${dto.num} ${dto.id} ${dto.orgname} ${dto.reg} <br />
	<hr />
</c:forEach>