<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
</head>
<body>

   
<h2>글작성</h2>
<hr/>
<form action="insert.do" method="post">
<table>
	<tbody>
		<tr>
			<td>제목 : <input type="text" name="title" ></td>
		</tr>
		<tr>
			<td>내용<td>
		</tr>
		<tr>
			<td> <textarea cols=30 rows="15" name="content"></textarea><td>
		</tr>
	</tbody>
</table>

<hr/>
<div>
<input type="submit" value="등록">
</div>
</form>
</body>
</html>