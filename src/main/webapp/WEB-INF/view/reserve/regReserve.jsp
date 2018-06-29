<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!-- /WebContent/reserve/regReserve.jsp -->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약 등록 화면</title>
</head>
<body>
<form:form modelAttribute="reserve" action="regForm.sms" method="post"name="f">
	<table border="1" cellpadding="0" cellspacing="0">
		<caption>예약등록하기</caption>
		
		<tr><td align="center">글쓴이</td><td><form:input path="id"/><!--<font color="red"><form:errors path="id"/></font></td>--></tr>
		<tr><td align="center">내용</td><td><form:textarea rows="15" cols="80" path="content"/><font color="red"><form:errors path="content"/></font></td></tr>
		<tr><td align="center" colspan="2"><a href="javascript:document.f.submit()">[게시물등록]</a>&nbsp;&nbsp;<a href="listex.sms">[게시판목록]</a></td></tr>
	</table>
</form:form>

</body>
</html>