<%-- <% 
	session.invalidate();
	response.sendRedirect("/mvc/member/main.do");
%> --%>
<%-- <%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>

<%-- <c:choose>
    <c:when test="${sessionScope.memId == null}">
    <!-- �α��� �κ� -->
        <div class="card">
            <h3>�α���</h3>
            <form method="post" action="${pageContext.request.contextPath}/member/loginPro.do">
                <input type="hidden" name="command" value="login">
                <p>���̵� <input type="text" name="Id" placeholder="���̵�" size="12"></p>
                <p>�н����� <input type="password" name="passwd" placeholder="��й�ȣ" size="12"></p>
                <input type="submit" value="�α���">
                <a href="${pageContext.request.contextPath}/member/inputForm.do?command=registerPage">ȸ������</a></p>
            </form>
        </div>            
    </c:when>
    <c:otherwise>
        <div class="card">        
            <p>${sessionScope.clientDTO.clientName}��    �ݰ����ϴ�.</p>
            <p><a href="${pageContext.request.contextPath}/member/modify.do?command=logout">�α׾ƿ�</a></p>
            <p><a href="#">ȸ������</a></p>         
            <p><a href="#">ȸ��Ż��</a></p>
            <p><a href="${pageContext.request.contextPath}/member/main.do">Ȩ����</a>  </p>
        </div>
        <!-- �޴��κ� -->
        <div class="card">
            <h3>�Խ���</h3>
            <a href="#">�Խ��� ����</a>  
        </div>
    </c:otherwise>
</c:choose> --%>

<%-- <c:if test="${sessionScope.memId == null}">
	<script>
	alert("���������� �α׾ƿ� �Ǿ����ϴ�.");
	history.go(-1);
	</script>
	<c:redirect url="/member/main.do" />
</c:if> --%>
<script>
	window.location="/spring/member/main.do";
</script>
