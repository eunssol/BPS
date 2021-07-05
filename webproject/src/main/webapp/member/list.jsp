<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>  
<%@ page import="member.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<style>
        table{
            table-layout: auto;
            width: 100%;
            border: 1px violet;
            border-collapse: collapse;
        }
        th, td {
            border:1px solid black;
            padding: 8px;
        }
    </style>
<body>
<h2>member List</h2>
<hr/>
<table>
	<thead>
		<tr>
			<th>memberno</th>
			<th>name</th>
			<th>id</th>
			<th>regdate</th>
		</tr>
	</thead>
	<tbody>
<c:forEach var="member" items="${list}">
		<tr>
			<td>${member.memberno }</td>
			<td> ${member.name }</td>
			<td> ${member.id }</td>
			<td> ${member.date2 }</td>
		</tr>
</c:forEach>

	</tbody>
</table>

</body>
</html>