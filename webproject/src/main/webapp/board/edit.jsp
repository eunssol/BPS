<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.*" %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
<h2>글 수정</h2>
<form action="update.do" method="post">
<table>
	<tbody>
		<tr>
			<td>제목 : <input type="text" name="title" value="${vo.title }"></td>
		</tr>
		<tr>
			<td>내용</td>
		</tr>
		<tr>
			<td><textarea cols=30 rows="15" name="content"  >${vo.content }</textarea></td>
		</tr>
	</tbody>
</table>>
<div>
<input type="submit" value="수정">
</div>
</form>
</body>
</html>