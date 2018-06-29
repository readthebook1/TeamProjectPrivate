<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="join.sms" method="post">
<table align="center" cellpadding="1" cellspacing="1" border = "1">
	<tr>
		<td>아이디 </td><td><input type="text" placeholder="영문과 숫자조합으로 가즈아!"  name="id"></td>
	</tr>
	<tr>
		<td>비밀번호 </td><td><input type="password" placeholder="쉬운건 하지 말즈아!" oninput="checkpwd()" name="id"></td>
	</tr>
	<tr>
		<td>비번 확인 </td><td><input type="password" placeholder="비번 입력 한번 더 가즈아!" oninput="checkpwd()" name="id"></td>
	</tr>
	<tr>
		<td>이름 </td><td><input placeholder="!" type="text" name="id"></td>
	</tr>
	<tr>
		<td>이메일 </td><td><input placeholder="자주 쓰는걸로 가즈아!" type="text" name="id" on></td>
	</tr>
	<tr>
		<td>생년월일 </td><td><input placeholder="영문과 숫자조합으로 가즈아!" type="text" name="id"></td>
	</tr>
	<tr>
		<td>아이디 </td><td><input placeholder="영문과 숫자조합으로 가즈아!" type="text" name="id"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="가입하기">
			<input type="button" onclick="javascript:history.go(-1)" value="뒤로가기"></td>
	</tr>
</table>
</form>
</body>
</html>