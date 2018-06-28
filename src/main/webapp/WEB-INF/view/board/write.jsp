<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SMS 공지사항</title>
</head>
<body>
<form:form modelAttribute="board" action="write.sms" method="post" name="f">
	<table border="0" cellpadding="0" cellspacing="0">
		<caption> SMS 공지사항 게시판</caption>
		<tr>
		<td align="center">제목</td>
		<td><form:input path="subject"/>
		<font color="red"><form:errors path="subject"/></font></td>
	</table>
	<tr>
		<td align="center">내용</td>
		<td><form:textarea rows="15" cols="80" path="content"/>
		<font color="red"><form:errors path="content"/></font></td>
		<tr>
		<td align="center" colspan="2">
		<a href="javascript:document.f.submit()">[공지사항 등록]</a>
		<a href="notice.sms">[공지사항 목록]</a></td></tr>
	</table>
</form:form>

</body>
</html>