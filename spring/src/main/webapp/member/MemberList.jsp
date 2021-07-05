<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style >
table{border: 1px solid black; border-collapse: collapse; padding: 5px 20px
}
tr,th,td{border: 1px solid black;}
</style>
<script type="text/javascript">
function del(no) {
	if(confirm("삭제하시겠습니까?")){
		location.href='delete.do?no='+no;
	}
	
}
</script>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>회원 목록</h1>
<p><a href='add.do'>신규 회원</a></p>
<table>
	<tr>
		<th><c:choose>	
		<c:when test="${orderCond == 'MNO_ASC' }"><a href='list.do?orderCond=MNO_DESC'> 번호↑</a></c:when>
		<c:when test="${orderCond == 'MNO_DESC' }"><a href='list.do?orderCond=MNO_ASC'> 번호↓</a></c:when>
		<c:otherwise><a href='list.do?orderCond=MNO_ASC'>번호</a></c:otherwise>
		</c:choose></th>
		<th><c:choose>
		<c:when test="${orderCond == 'NAME_ASC' }"><a href='list.do?orderCond=NAME_DESC'>이름↑</a></c:when>
		<c:when test="${orderCond == 'NAME_DESC' }"><a href='list.do?orderCond=NAME_ASC'>이름↓</a></c:when>
		<c:otherwise><a href='list.do?orderCond=NAME_ASC'>이름</a></c:otherwise>
		</c:choose></th>
		<th><c:choose>
		<c:when test="${orderCond == 'EMAIL_ASC' }"><a href='list.do?orderCond=EMAIL_DESC'>이메일↑</a></c:when>
		<c:when test="${orderCond == 'EMAIL_DESC' }"><a href='list.do?orderCond=EMAIL_ASC'>이메일↓</a></c:when>
		<c:otherwise><a href='list.do?orderCond=EMAIL_ASC'>이메일</a></c:otherwise>
		</c:choose></th>
		<th><c:choose>
		<c:when test="${orderCond == 'CRE_DATETIME_ASC' }"><a href='list.do?orderCond=CRE_DATETIME_DESC'>등록일↑</a></c:when>
		<c:when test="${orderCond == 'CRE_DATETIME_DESC' }"><a href='list.do?orderCond=CRE_DATETIME_ASC'>등록일↓</a></c:when>
		<c:otherwise><a href='list.do?orderCond=CRE_DATETIME_ASC'>등록일</a></c:otherwise>
		</c:choose></th>
		<th></th>
	</tr>
<c:forEach var="member" items="${members }">
	<tr>
		<td>${member.no }</td>
		<td><a href="update.do?no=${member.no}">${member.name }</a></td>
		<td>${member.email }</td>
		<td>${member.createdDate }</td>
		<td><a href ="javascript:del(${member.no });">[삭제]</a></td>
	</tr>
</c:forEach>
</table>
<jsp:include page="/Tail.jsp"/>
</body>
</html>