<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function(){
	$("#btn").click(function(){
		var html = '';
		html += '<tr>';
		html += '<td><input type="text" name="title"></td>';
	  	html += '<td><input type="text" name="content"></td>';
		html += '</tr>';
		$("#tbl").append(html);
	});
});
function check() {
	var go = true;
	$("input[name='title']").each(function(i){
		//console.log(i);
		if($("input[name ='title']").eq(i).val() == ''){
			alert((i+1)+"행의 제목을 입력해 주세요");
			$("input[name ='title']").eq(i).focus();
			go = false;
			return false;
		}
	})
	return go;
}
function send() {
	$("#frm").submit();
}
</script>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="btn" value="추가">
<form id="frm" action="insert.jsp" method="post" onsubmit="return check();">
	<table id= "tbl" border="1">
		<tr>
			<td>제목</td>
			<td>내용</td>
		</tr>
		<tr>
			<td><input type="text" name="title"></td>
			<td><input type="text" name="content"></td>
		</tr>
	</table>
	<!--  <input type="button" onclick="send();" value="저장">-->
	<input type="submit" value="저장">
</form>
</body>
</html>