package com.eomcs.mylist.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.eomcs.mylist.domain.Member;

// 역할:
// - HttpSession 객체를 생성할 때, 기능 테스트를 위해 자동으로 로그인 시킨다.
//
@WebListener
public class AutoLoginListener implements HttpSessionListener {
  @Override
  public void sessionCreated(HttpSessionEvent se) {
    System.out.println("AutoLoginListener.sessionCreated() 호출됨!");
    Member loginUser = new Member();
    loginUser.setNo(2);
    loginUser.setName("user2");

    HttpSession session = se.getSession();
    session.setAttribute("loginUser", loginUser);
  }
}









