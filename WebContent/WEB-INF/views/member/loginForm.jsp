<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/resource/etc/color.jspf"%>
<html>
<head>
<title>�α�����</title>
<link href="/spring/resource/style/style.css" rel="stylesheet" type="text/css">
	<script language="javascript">
     
       function begin(){
         document.myform.id.focus();
       }
       function checkIt(){
         if(!document.myform.id.value){
           alert("���̵� �Է����� �����̽��ϴ�.");
           document.myform.id.focus();
           return false;
         }
         if(!document.myform.passwd.value){
           alert("��й�ȣ�� �Է����� �����̽��ϴ�.");
           document.myform.passwd.focus();
           return false;
         }
         
       }
     
   </script>
</head>
<BODY onload="begin()" bgcolor="${bodyback_c}">
<form name="myform" action="/spring/member/loginPro.do" method="post" onSubmit="return checkIt()">
<TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
  
  <TR height="30">
    <TD colspan="2" align="middle" bgcolor="${title_c}"><STRONG>ȸ���α���</STRONG></TD></TR>
  
  <TR height="30">
    <TD width="110" bgcolor="${title_c}" align=center>���̵�</TD>
    <TD width="150" bgcolor="${value_c}" align=center>
       <INPUT type="text" name="id" size="15" maxlength="12"></TD></TR>
  <TR height="30">
    <TD width="110" bgcolor="${title_c}" align=center>��й�ȣ</TD>
    <TD width="150" bgcolor="${value_c}" align=center>
      <INPUT type=password name="passwd"  size="15" maxlength="12"></TD></TR>
  <TR height="30">
    <TD colspan="2" align="middle" bgcolor="${title_c}" >
      <INPUT type=submit value="�α���"> 
      <INPUT type=reset value="�ٽ��Է�">
      <input type="button" value="ȸ������" onclick="javascript:window.location='/spring/member/inputForm.do'"></TD></TR>
</TABLE>
</form>

</BODY>
</HTML>