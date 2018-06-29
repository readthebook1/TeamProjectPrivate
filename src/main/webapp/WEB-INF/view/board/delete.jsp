<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 삭제</title>
</head>
<body>
<form name="f" method="post" action="delete.sms?pageNum=${param.pageNum}&bNO=${board.bNo}">
	<input type="hidden" name="bNo"	value="${param.bNo}">
	<input type="hidden" name="pageNum"	value="${param.pageNum}">
	<table border="1" cellspacing="0" cellpadding="0">
	<tr><td>비밀번호를 입력해주세요. </td>
		<td><input type="password" name="pass"></td>
	</tr>
	<tr><td colspan="2" align="center">
		<a href="javascript:document.f.submit()">[삭제]</a>
	</td></tr>
	</table>
</form>
</body>
</html>