package com.eomcs.mylist.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.eomcs.mylist.domain.Member;

// 역할:
// - 요청이 들어올 때, 기능 테스트를 위해 자동으로 로그인 시킨다.
//
@WebListener
public class AutoLoginListener implements ServletRequestListener {

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("AutoLoginListener.requestInitialized() 호출됨!");
    Member loginUser = new Member();
    loginUser.setNo(23);
    loginUser.setName("user20");

    HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest();
    HttpSession session = httpRequest.getSession();
    session.setAttribute("loginUser", loginUser);
  }  
}









