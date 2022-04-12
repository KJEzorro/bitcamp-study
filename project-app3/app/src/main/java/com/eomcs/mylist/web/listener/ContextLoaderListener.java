package com.eomcs.mylist.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 역할:
// - 웹애플리케이션이 시작될 때 서비스 객체, DAO 객체, Mybatis 객체를 준비한다.
//
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 웹애플리케이션이 시작되면 이 메서드가 호출될 것이다.

    // 1) Mybatis의 sqlSessionFactory 준비
  }

}
