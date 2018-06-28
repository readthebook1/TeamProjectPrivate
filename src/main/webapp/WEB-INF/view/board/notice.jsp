<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 목록</title>
<script type="text/javascript">
	function list(pageNum) {
		if(searchType == null || searchType.length == 0) {
			document.searchform.searchContent.value = "";
			document.searchform.pageNum.value = "1";
			location.href="list.sms?pageNum=" + pageNum/
		}else{
			document.searchform.pageNum.value = pageNum;
			documetn.searchform.submit();
			return true;
		}
		return false;
	}
</script>
</head>
<body>
<div>
<form action="list.sms" method="post" name="searchform" onsubmit="return list(1)">
<div>
<dl>
<dt>
<label>공지사항 검색</label>
</dt>
<dd>
<input type="hidden" name="pageNum" value="1">
<input type="text" name="searchContent" value="${param.searchContent}">
</dd>
</dl>
</div>
</form>
</div>
</body>
</html>