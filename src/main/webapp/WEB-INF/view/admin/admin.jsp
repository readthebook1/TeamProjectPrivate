<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<%-- /WebContent/WEB-INF/view/admin/admin.jsp --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>관리자</title>
<script type="text/javascript">
	function allchkbox(chk) {
		
		var chks = document.getElementsByName("idchks")
		
		for(var i=0; i < chks.length; i++) {
			chks[i].checked = chk.checked;
		}
	}
	
	function graph_open(url) {
		var op = "width=700, height=500, scrollbars=yes, left=50, top=150"
		window.open(url+".shop","graph",op)
	}
</script>
</head>
<body>

<form action="mailForm.shop" method="post">
	<table class="w3-table w3-striped">
		
		<tr>
			<td colspan="7" align="center">회원목록</td>
		</tr>
		
		<tr>
			<td>아이디</td><td>이름</td><td>전화번호</td><td>이메일</td><td>생일</td><td>비고</td>
			<td><input type="checkbox" name="allchk" onchange="allchkbox(this)"></td>
		</tr>
		
		<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.userId}</td><td>${user.userName}</td><td>${user.phoneNo}</td><td>${user.email}</td>
			<td><fmt:formatDate value="${user.birthDay}" pattern="yyyy-MM-dd"/></td>
			<td><a href="../user/update.shop?id=${user.userId}">수정</a>
				<c:if test="${user.userId != 'admin'}"><a href="../user/delete.shop?id=${user.userId}">삭제</a></c:if>
			<a href="../user/mypage.shop?id=${user.userId}">정보</a></td>
			<td><input type="checkbox" name="idchks" value="${user.userId}"></td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="7" align="center">
				<input type="submit" value="SendEmail">
				<input type="button" value="Graph(π)" onclick="graph_open('graph1')">
				<input type="button" value="Graph(Cloud)" onclick="graph_open('graph2')">
			</td>
		</tr>
	</table>
</form>

</body>
</html>