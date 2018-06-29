<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%-- /WebContent/decorator/decorator_test_bar.jsp --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>
<decorator:title/>
</title>
<decorator:head/>
</head>
<body>
<div class="w3-sidebar w3-bar-block w3-card w3-animate-right" style="display:none;right:0;" id="rightMenu">
  <button onclick="closeRightMenu()" class="w3-bar-item w3-button w3-large">Close &times;</button>
  <c:if test="${empty sessionScope.loginMember.id}"><a href="login.sms" class="w3-bar-item w3-button">로그인/회원가입</a></c:if>
  <c:if test="${!empty sessionScope.loginMember.id}"><a href="#" class="w3-bar-item w3-button">로그아웃</a></c:if>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
</div>


<div class="w3-purple">
  <button class="w3-button w3-purple w3-xlarge w3-right" onclick="openRightMenu()">&#9776;</button>
  <div class="w3-container">
    <h1><a href="../main.sms">Space</a></h1>
  </div>
</div>

<script>
function openLeftMenu() {
    document.getElementById("leftMenu").style.display = "block";
}
function closeLeftMenu() {
    document.getElementById("leftMenu").style.display = "none";
}

function openRightMenu() {
    document.getElementById("rightMenu").style.display = "block";
}
function closeRightMenu() {
    document.getElementById("rightMenu").style.display = "none";
}
</script>


<div class="w3-container">
<decorator:body/>
</div>
<div class="w3-container w3-light-gray" align="right"><p>	
동해물과 백두산이<br>
마르고 닳도록<br>
</p></div>

</body>

</html>

