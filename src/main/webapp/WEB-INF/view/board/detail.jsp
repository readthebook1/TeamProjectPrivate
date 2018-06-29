<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>SPRING ê²???ê¸? ???¸ë³´ê¸?</title>
</head>
<body>

<div class="w3-container">
	<div class="w3-panel w3-leftbar w3-border-teal">
	</div>
	<div class="w3-panel w3-leftbar w3-border-green w3-text-dark-gray">
	
	Writer : ${board.id}<br>
	<p>Date : <fmt:formatDate value="${board.regDate}"  pattern="yyyy-MM-dd HH:mm" /></p>
	</div>
	
  <div class="w3-panel w3-bottombar w3-leftbar w3-border-teal" style="width:70%">
    <p>${board.content}</p>
    <hr>
   </div>
   <form action="" name="f">
   <input type="hidden" name="bNo" value="${board.bNo}">
   <input type="hidden" name="pageNum" value="${param.pageNum}">
  	<div class="w3-panel" align="right" style="width:70%" >
  	<a href="reply.sms?bNo=${board.bNo}&pageNum=${param.pageNum}"><font class="w3-btn" style="color:gray;"><i class="fa fa-reply-all">&nbsp;Reply</i></font></a>
  	<a href="list.sms?pageNum=${param.pageNum}"><font class="w3-btn" style="color:gray;"><i class="fa fa-list-alt">&nbsp;List</i></font></a>
  	<a href="update.sms?bNo=${board.bNo}&pageNum=${param.pageNum}"><font class="w3-btn" style="color:gray;"><i class="fa fa-edit" >&nbsp;Edit</i></font></a>
  	<a href="delete.sms?bNo=${board.bNo}&pageNum=${param.pageNum}"><font class="w3-btn" style="color:gray;"><i class="fa fa-trash-o">&nbsp;Delete</i></font></a>
  	<br>
	</div>
	</form>
</div>

</body>
</html>