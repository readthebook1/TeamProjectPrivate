<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 수정</title>
<script type="text/javascript">
	function file_delete() {
		document.f.file2.value=""; 
		file_desc.style.display="none";
	}
</script>
</head>
<body>
<form:form modelAttribute="board" action="update.shop?num=${board.num}&pageNum=${param.pageNum }" method="post" enctype="multipart/form-data" name="f">
  <spring:hasBindErrors name="board">
  	<font color="red">
  	  <c:forEach items="${errors.globalErrors}" var="error">
  	  	<spring:message code="${error.code}"/>
  	  </c:forEach>
  	</font>
  </spring:hasBindErrors>
  <input type="hidden" name="bNo" value="${board.bNo}">
  <input type="hidden" name="file2" value="${board.fileurl}">
  <input type="hidden" name="pageNum" value="${param.pageNum}">
  		<input type="hidden" name="kind" value="${board.kind}">
  <table border="1" cellpadding="0" cellspacing="0">
  <caption>게시판 수정</caption>
  <tr><td align="center">비밀번호</td><td><form:password path="pass"/>
  		<font color="red"><form:errors path="pass"/></font></td></tr>
 <tr><td align="center">제목</td><td><form:input path="subject" value="${board.subject}"/>
  		<font color="red"><form:errors path="subject"/></font></td></tr>
  	<tr><td align="center">내용</td>
  		<td><form:textarea rows="15" cols="80" path="content"/>
  		<font color="red"><form:errors path="content"/></font></td></tr>
  	<tr><td align="center">첨부파일</td>
  		<td><c:if test="${!empty board.fileurl }">
  		<div id="file_desc">
  			<a href="picture/${board.fileurl}">${board.fileurl}</a>
  			<a href="javascript:file_delete()">사진없음</a></div>
  	  </c:if>
  		<input type="file" name="file1" ></td></tr>
  	<tr><td align="center" colspan="2">
  		<a href="javascript:document.f.submit()">[수정]</a>
  		<a href="list.shop">[목록]</a>
  	</td></tr></table></form:form>
</body>
</html>