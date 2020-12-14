<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<h1>fileNum.jsp</h1>
<hr>
<h1>id = ${id}</h1>
<hr>
<c:forEach var="savename" items="${list}">
	<h1>파일이름 = ${savename}</h1>
	<hr>
	<h1>original name = ${orgname}</h1>
</c:forEach>