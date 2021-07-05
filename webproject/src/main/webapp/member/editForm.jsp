<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정폼</title>
</head>
<body>
<h2>회원정보변경</h2>
<form action="edit.do" method="post">
아이디 : ${data.id }<br>
비밀번호 : <input type="password" name="pwd" value="">${msg.pwdMsg }<br>
이름 : <input type="text" name="name" value="${data.name }">${msg.nameMsg }<br>
<input type="submit" value="회원정보수정">
<input type="hidden" name="memberno" value="${data.memberno }">
</form>
</body>
</html>