<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<h1>게시글2</h1>
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
<%
int pageNo = (int) request.getAttribute("pageNo");
int pageSize = (int) request.getAttribute("pageSize");
int totalPageSize = (int) request.getAttribute("totalPageSize");
List<Board> boards = (List<Board>) request.getAttribute("list");
for (Board board : boards) {
%>
  <tr>
    <td><%=board.getNo()%></td>
    <td><a href='view?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
    <td><%=board.getWriter().getName()%></td>
    <td><%=board.getViewCount()%></td>
    <td><%=board.getCreatedDate()%></td>
  </tr>
<%
}
%>
</tbody>
</table>
<div>
<%if (pageNo > 1) { %>
<a href="list?pageNo=<%=pageNo - 1%>&pageSize<%=pageSize%>">[이전]</a>
<%} else {%>
[이전]
<%} %>
<%=pageNo%>
<%if (pageNo < totalPageSize) { %>
<a href="list?pageNo=<%=pageNo + 1%>&pageSize<%=pageSize%>">[다음]</a>
<%} else {%>
[다음]
<%} %>
</div>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

</div>
</body>
</html>
