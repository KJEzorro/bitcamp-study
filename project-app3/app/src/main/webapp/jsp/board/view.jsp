<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="com.eomcs.mylist.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
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
<%
int no = Integer.parseInt(request.getParameter("no"));
BoardService boardService = (BoardService) application.getAttribute("boardService");
Board board = boardService.get(no);
%>
<h1>게시글 상세</h1>
<form action='update.jsp' method='post'>
번호: <input name="no" type="text" value='<%=board.getNo()%>' readonly><br>
제목*: <input name="title" type="text" value='<%=board.getTitle()%>'><br>
내용*: <textarea name="content" cols="50" rows="10"><%=board.getContent()%></textarea><br>
작성자: <span><%=board.getWriter().getName()%></span><br>
조회수: <span><%=board.getViewCount()%></span><br>
등록일: <span><%=board.getCreatedDate()%></span><br>
별표(*) 항목은 필수 입력입니다.<br>
<button>변경</button>
<button id='delete-btn' type="button">삭제</button>
<button id='cancel-btn' type="button">취소</button>
</form>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

</div>

<script>
document.querySelector('#delete-btn').onclick = () => {
  location.href = 'delete.jsp?no=' + document.querySelector('input[name=no]').value;
}
document.querySelector('#cancel-btn').onclick = () => {
  location.href = 'list.jsp';
}
</script>

</body>
</html>
