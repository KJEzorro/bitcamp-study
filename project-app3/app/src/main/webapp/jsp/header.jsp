<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
#login-btn {
  position: absolute;
  right: 10px;
}
#logout-btn {
  position: absolute;
  right: 10px;
}
#app-title {
  font-size: 1.5em;
  font-weight: bold;
  font-style: none;
  color: white;
} 
#user-name {
  position: absolute;
  right: 90px;
}
</style>
<a href="/index.html"><span id="app-title">MyList</span></a> 
<button id="login-btn" type="button" class="not-login">로그인</button>
<span id="user-name" class="login"></span>
<button id="logout-btn" type="button" class="login">로그아웃</button>  