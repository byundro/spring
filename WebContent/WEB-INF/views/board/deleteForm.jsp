<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resource/etc/color.jspf"%>

<html>
<head>
<title>�Խ���</title>
<link href="/spring/resource/style/style_board.css" rel="stylesheet" type="text/css">

<script language="JavaScript">      
<!--      
  function deleteSave(){	
	if(document.delForm.passwd.value==''){
	alert("��й�ȣ�� �Է��Ͻʽÿ�.");
	document.delForm.passwd.focus();
	return false;
 }
}    
// -->      
</script>
</head>

<body bgcolor="${bodyback_c}">
<center><b>�ۻ���</b>
<br>
<form method="POST" name="delForm"  action="/study/board/deletePro.do?pageNum=${pageNum}" 
   onsubmit="return deleteSave()"> 
 <table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
  <tr height="30">
     <td align=center  bgcolor="${value_c}">
       <b>��й�ȣ�� �Է��� �ּ���.</b></td>
  </tr>
  <tr height="30">
     <td align=center >��й�ȣ :   
       <input type="password" name="passwd" size="8" maxlength="12">
	   <input type="hidden" name="num" value="${num}"></td>
 </tr>
 <tr height="30">
    <td align=center bgcolor="${value_c}">
      <input type="submit" value="�ۻ���" >
      <input type="button" value="�۸��" 
       onclick="document.location.href='/study/board/list.do?pageNum=${pageNum}'">     
   </td>
 </tr>  
</table> 
</form>
</body>
</html> 