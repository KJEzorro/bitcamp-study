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
<h1>게시글 등록</h1>
<form action="add.jsp" method='post'>
제목*: <input name="title" type="text"><br>
내용*: <textarea name="content" cols="50" rows="10"></textarea><br>
별표(*) 항목은 필수 입력입니다.<br>
<button>등록</button>
<button id='cancel-btn' type="button">취소</button>
</form>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

</div>

<script>
document.querySelector('#cancel-btn').onclick = () => {
  location.href = 'list.jsp';
}
</script>

</body>
</html>
