<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>MyList!</title>
  <link href="/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">

<div id="header">
<jsp:include page="/jsp/header.jsp"></jsp:include>
</div>

<div id="sidebar">
<jsp:include page="/jsp/sidebar.jsp"></jsp:include>
</div>

<div id="content">
<h1>게시글6(+ JSP액션태그 + JSTL + EL)</h1>
<a href="add">새 게시글</a>
<table id="x-board-table" border="1">
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>조회수</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>
<c:forEach var="board" items="${list}">
  <tr>
    <td>${board.no}</td>
    <td><a href='detail?no=${board.no}'>${board.title}</a></td>
    <td>${board.writer.name}</td>
    <td>${board.viewCount}</td>
    <td>${board.createdDate}</td>
  </tr>
</c:forEach>
</tbody>
</table>
<div>

<c:if test="${pageNo > 1}">
  <a href="list?pageNo=${pageNo - 1}&pageSize=${pageSize}">[이전]</a>
</c:if>
<c:if test="${pageNo <= 1}">
  [이전]
</c:if>

${pageNo}

<c:choose>
  <c:when test="${pageNo < totalPageSize}"> 
    <a href="list?pageNo=${pageNo + 1}&pageSize=${pageSize}">[다음]</a>
  </c:when>
  <c:otherwise>
    [다음]
  </c:otherwise>
</c:choose>

</div>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

</div>
</body>
</html>
