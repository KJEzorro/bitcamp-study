package com.eomcs.mylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @WebFilter, @WebListener 등 Servlet API 애노테이션이 붙은 클래스(서블릿 관련 컴포넌트)는
// 스프링부트에서 관리하지 않는다.
// 따라서 Servlet API로 만든 서블릿, 필터, 리스너가 동작하지 않는다.
// Servlet API로 만든 컴포넌트를 스프링부트에서 실행하고 싶다면 다음 애노테이션으로
// 그들 클래스가 있는 패키지를 지정하라!
@ServletComponentScan("com.eomcs.mylist.web")

@EnableTransactionManagement // 애노테이션으로 트랜잭션을 제어할 수 있게 한다.
@SpringBootApplication
public class App {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(App.class, args);
  }

}
