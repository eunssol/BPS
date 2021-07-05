<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="toolbar-bottom">
  <div class="toolbar mt-lg">
    <div class="sorter">
      <ul class="pagination">
        <li><a href="javascript:PageMove(${paging.firstPageNo})">맨앞으로</a></li>
        <li><a href="javascript:PageMove(${paging.prevPageNo})">앞으로</a></li>
              <c:foreach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
                  <c:choose>
                      <c:when test="${i eq paging.pageNo}">
                <li class="active"><a href="javascript:PageMove(${i})">${i}</a></li>
                      </c:when>
                      <c:otherwise>
                        <li><a href="javascript:PageMove(${i})">${i}</a></li>
                      </c:otherwise>
                  </c:choose>
              </c:foreach>
        <li><a href="javascript:PageMove(${paging.nextPageNo})">뒤로</a></li>
        <li><a href="javascript:PageMove(${paging.finalPageNo})">맨뒤로</a></li>
      </ul>
    </div>
  </div>
</div>


</body>
</html>