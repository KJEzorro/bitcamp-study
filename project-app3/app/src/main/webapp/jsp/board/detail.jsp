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

<h1>게시글 상세4(+ JSP 액션 태그 + JSTL + EL)</h1>
<form action='update' method='post'>
번호: <input name="no" type="text" value='${board.no}' readonly><br>
제목*: <input name="title" type="text" value='${board.title}'><br>
내용*: <textarea name="content" cols="50" rows="10">${board.content}</textarea><br>
작성자: <span>${board.writer.name}</span><br>
조회수: <span>${board.viewCount}</span><br>
등록일: <span>${board.createdDate}</span><br>
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
  location.href = 'delete?no=' + document.querySelector('input[name=no]').value;
}
document.querySelector('#cancel-btn').onclick = () => {
  location.href = 'list';
}
</script>

</body>
</html>
