<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상세보기</title>
</head>
<body>
<table align="center" border="1" cellpadding="0" cellspacing="0">
  <tr><td colspan="2" align="center">상세보기</td></tr>
  <tr><td>작성자</td><td>${board.name}</td></tr>
  <tr><td>제목</td><td>${board.subject}</td></tr>
  <tr><td>내용</td><td>
  	  <table border="0" width="490" height="250">
  	  <tr><td>${board.content}</td></tr>
  	  </table></td></tr>
  <tr><td>첨부파일</td>
  	  <td>&nbsp;
  	  <c:if test="${!empty board.fileurl }">
  	      <a href="../picture/${board.fileurl}">${board.fileurl}</a>
  	  </c:if>&nbsp;</td></tr>
  <tr><td colspan="2" align="center">
  	<a href="reply.shop?num=${board.num}&pageNum=${param.pageNum}">[답글]</a>
  	<a href="update.shop?num=${board.num}&pageNum=${param.pageNum}">[수정]</a>
  	<a href="delete.shop?num=${board.num}&pageNum=${param.pageNum}">[삭제]</a>
  	<a href="list.shop?pageNum=${param.pageNum}">[목록]</a>
  	</td></tr>
</table>
</body>
</html>