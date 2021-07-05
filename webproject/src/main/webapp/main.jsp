<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty loginInfo }">
${loginInfo.name }님 반갑습니다.
<a href="/webproject/member/logout.do">로그아웃</a>
<a href="/webproject/member/edit.do">회원정보변경</a><br>
<a href="/webproject/board/index.do">글 목록</a>
</c:if>
<c:if test="${empty loginInfo }">
<a href="/webproject/member/login.do">로그인</a>
<a href="/webproject/member/join.do">회원가입</a>
</c:if>
</body>
</html>