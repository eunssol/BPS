<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="spms.vo.*" %>
    <%
    Member member = (Member)request.getAttribute("member");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<script type="text/javascript">
function del() {
	if(confirm('삭제하시겠습니까?')){
		location.href='delete.do?no=${param.no}';
	}
	
	
}
</script>
</head>
<body>
<h1>회원 정보</h1>
<form action='update.do' method='post'>
	번호:<input type='text' name='no' value='${param.no}'readonly ><br>
	이름:<input type='text' name='name' value='${member.name}'><br>
	이메일: <input type='text' name ='email' value="${member.email}"><br>
	가입일: ${member.createdDate} 

<input type='submit' value='저장'>
<input type='button' value='삭제' onclick="del();">
<input type='button' value='취소' onclick='history.back();'>
</form>
</body>
</html>