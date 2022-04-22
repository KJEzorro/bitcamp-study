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
<h1>실행 오류!</h1>
<%
Exception e = (Exception) request.getAttribute("exception");
%>
<p><%=e.getMessage()%></p>
</div>

<div id="footer">
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</div>

</div>
</body>
</html>
