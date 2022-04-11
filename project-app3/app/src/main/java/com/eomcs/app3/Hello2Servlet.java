package com.eomcs.app3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@SuppressWarnings("serial")
@WebServlet("/hello2") // 서블릿 컨테이너에게 이 클래스가 /hello 요청을 처리하는 서블릿임을 알려준다.
public class Hello2Servlet extends GenericServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    System.out.println("service() 호출");

    // HTTP 클라이언트가 name이란 이름으로 보내 온 값을 읽는다.
    String name = req.getParameter("name");

    // HTTP 클라이언트에게 보낼 콘텐트의 MIME 타입을 설정한다.
    res.setContentType("text/plain;charset=UTF-8");

    // HTTP 클라이언트에게 콘텐트를 출력할 도구를 준비한다.
    PrintWriter out = res.getWriter();

    // HTTP 클라이언트에게 콘텐트를 출력한다.
    out.printf("%s 님 환영합니다!", name);

  }

}
