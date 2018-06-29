<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>쉐마쉐 로그인! &gt;&lt;</title>
</head>
<body>
 <form action="login.sms" method="post">
 <table align="center" cellpadding="1" cellspacing="1" border="1" height="200" width="300">
 <tr>
 	<td align="center">아이디</td><td><input  type="text" name="id"></td>
 </tr>
 <tr>
 	<td align="center">비밀번호</td><td><input align="middle"  type="password" name="password"></td> 
 </tr>
 <tr>
  	<td colspan="2" align="center"><input type="submit" value="로그인">
  	<input type="button" onclick="location.href='joinForm.sms'" value="가입하기"></td>
  </tr>
 </table>
 </form>
</body>
</html>