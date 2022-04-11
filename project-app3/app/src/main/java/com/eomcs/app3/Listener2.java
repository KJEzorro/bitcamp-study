package com.eomcs.app3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 서블릿 컨테이너가 특정 상태에 놓일 때 수행할 작업이 있다면 리스너 클래스에 정의하라
// 
@WebListener // 서블릿 컨테이너에게 리스너 등록
public class Listener2 implements ServletContextListener { // 서블릿 컨테이너가 시작, 종료할 때

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 서버가 시작하면 호출됨
    System.out.println("Listener2.contextInitialized() 호출");
  }


  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // 서버가 종료하면 호출됨
    System.out.println("Listener2.contextDestroyed() 호출");
  }


}
