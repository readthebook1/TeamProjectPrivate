<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���몃낫湲�</title>
</head>
<body>
<table align="center" border="1" cellpadding="0" cellspacing="0">
  <tr><td colspan="2" align="center">���몃낫湲�</td></tr>
  <tr><td>���깆��</td><td>${board.name}</td></tr>
  <tr><td>��紐�</td><td>${board.subject}</td></tr>
  <tr><td>�댁��</td><td>
  	  <table border="0" width="490" height="250">
  	  <tr><td>${board.content}</td></tr>
  	  </table></td></tr>
  <tr><td>泥⑤�����</td>
  	  <td>&nbsp;
  	  <c:if test="${!empty board.fileurl }">
  	      <a href="../picture/${board.fileurl}">${board.fileurl}</a>
  	  </c:if>&nbsp;</td></tr>
  <tr><td colspan="2" align="center">
  	<a href="reply.shop?num=${board.num}&pageNum=${param.pageNum}">[�듦�]</a>
  	<a href="update.shop?num=${board.num}&pageNum=${param.pageNum}">[����]</a>
  	<a href="delete.shop?num=${board.num}&pageNum=${param.pageNum}">[����]</a>
  	<a href="list.shop?pageNum=${param.pageNum}">[紐⑸�]</a>
  	</td></tr>
</table>
</body>
</html>