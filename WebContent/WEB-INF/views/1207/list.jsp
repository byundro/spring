<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:forEach var="dto" items="${list}">
	${dto.num} ${dto.id} 
	<a href="/spring/file/down.do?file=${dto.savename}">${dto.orgname}</a>
	 ${dto.reg}  <br />
	<hr />
</c:forEach>