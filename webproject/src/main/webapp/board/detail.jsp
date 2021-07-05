<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
   
<body>
<h2>글상세</h2>
<table>
	<tbody>
		<tr >
			<td>글번호:${vo.boardno }</td>
			<td>제목:${vo.title }</td>
			<td>조회수:${vo.readcnt }</td>
		</tr>
		<tr>
			<td>내용:</td>
		</tr>
		<tr>
			<td  colspan="3" >${vo.content }</td>
		</tr>
		<tr>
			<td colspan="3">등록일${vo.regdate }</td>
		</tr>
	</tbody>
</table>
<hr/>
<a href="edit.do?boardno=${vo.boardno }">수정</a>
<a href="delete.do?boardno=${vo.boardno }">삭제</a>
</body>
</html>