<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- �ڵ带 ��ġ�� ��Ŭ��� �̱⿡ jstl�����Ŀ� ��Ŭ����Ѵ�. --%>
<c:if test="${check == 1}">
	<c:redirect url="/member/main.do" />
</c:if>
<c:if test="${check == 0}">
		<script>
		alert("��й�ȣ�� ���� �ʽ��ϴ�.");
		history.go(-1);
		</script>
</c:if>
<c:if test="${check == -1}">
		<script>
		alert("���̵� üũ�� �ּ���.");
		history.go(-1);
		</script>
</c:if>		