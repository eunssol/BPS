<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.*" %>  
<%@ page import="java.util.*" %>  
<%
List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
int totalPage = (Integer)request.getAttribute("totalPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	
	table{
	table-layout: fixed;
	border: 3px black;
	border-collapse: collapse;height:80%; width:100%;
	
	}
	
	th,td{
	border: 1px solid black;
	padding: 15px;}
	
</style>
<body>
<h2>목록</h2>
 
<%if(list.size()==0){%>
	등록된 글이 없습니다<br>
<%}%>
<form action="index.do" >
<input type="text" name="searchWord" value="<%=request.getParameter("searchWord")==null?"":request.getParameter("searchWord")%>">
<input type="submit" value="검색">
</form>
<table>
<thead>
	<tr>	
		<th>번호</th>
		<ll?"1":request.getParameter("pagth>제목</th>
		<th>조회수</th>
		<th>작성일</th>
	</tr>
</thead>


<tbody>
<%for(int i=0; i<list.size();i++){ %>
	<tr>
		<td><%=list.get(i).getBoardno() %></td> 
		<td><a href="detail.do?boardno=<%=list.get(i).getBoardno()%>"> <%=list.get(i).getTitle() %></a></td> 
		<td><%=list.get(i).getReadcnt() %></td>
		<td><%=list.get(i).getDate()%></td>
	</tr>
<%}%>
</tbody>
	<tr>
		<td colspan="4">
			<% for(int i=1; i<=totalPage;i++){ %>
				<a href="index.do?page=<%=i%>&searchWord=${param.searchWord}">[<%=i%>]</a>
				
			<%}%>
		</td>
	</tr>
</table>
<a href="write.do">글등록</a>
</body>
</html>