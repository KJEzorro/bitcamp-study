package com.eomcs.app3;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

// 서블릿 컨테이너가 특정 상태에 놓일 때 수행할 작업이 있다면 리스너 클래스에 정의하라
// 
@WebListener // 서블릿 컨테이너에 리스너 등록
public class Listener1 implements ServletRequestListener { // 요청, 응답 상태일 때
  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    // 요청이 들어오면 필터를 실행하기 전에 호출됨.
    System.out.println("Listener1.requestInitialized() 호출");
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    // 응답을 완료할 때 필터 실행 후에 호출됨.
    System.out.println("Listener1.requestDestroyed() 호출");
  }

}
