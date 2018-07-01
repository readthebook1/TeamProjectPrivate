<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="room" action="roomSuccess.sms" method="post" >
<strong>SNo</strong><form:input path="sNo"/>
<strong>SRNo</strong><form:input path="sRNo"/>
 <input type="submit" value="룸 등록하기">
</form:form> 


</body>
</html>