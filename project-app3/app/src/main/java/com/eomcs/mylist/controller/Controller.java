package com.eomcs.mylist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 페이지 컨트롤러가 반드시 갖춰야 할 기능 정의
// => 프론트 컨트롤러(caller)가 페이지 컨트롤러(callee)를 사용할 때 호출하는 규칙
//
public interface Controller {

  String excute(HttpServletRequest request, HttpServletResponse response) throws Exception;



}
