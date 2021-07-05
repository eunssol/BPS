<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
</head>
<body>
<h2>회원가입</h2>
<form action="join.do" method="post">
아이디 : <input type="text" name="id" value="${param.id }">${msg.idMsg }${msg.idDupMsg }<br>
비밀번호 : <input type="password" name="pwd" value="${param.pwd }">${msg.pwdMsg }<br>
이름 : <input type="text" name="name" value="${param.name }">${msg.nameMsg }<br>
<input type="submit" value="회원가입">
</form>
</body>
</html>