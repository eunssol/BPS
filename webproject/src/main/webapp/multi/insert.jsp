<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdbc.*" %>
<%@ page import="board.*" %>
<%@ page import="java.sql.*" %>
<%
String[] titles = request.getParameterValues("title");
String[] contents = request.getParameterValues("content");

Connection conn = JdbcUtil.getConnection();
BoardDAO dao = BoardDAO.getInstance();

int cnt = 0;
for(int i = 0; i<titles.length; i++){
	//out.print(titles[i]+" "+contents[i]+"<br>");
	BoardVO vo = new BoardVO();
	vo.setTitle(titles[i]);
	vo.setContent(contents[i]);
	cnt += dao.insert(conn, vo);
	
}
%>
총 <%=cnt%> 개의 글이 등록되었습니다.