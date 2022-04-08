package com.eomcs.app3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 서블릿 컨테이너가 실행할 클래스를 만들려면
// Servlet API 규칙에 따라 작성해야 한다.
// 

@WebServlet("/hello")
public class HelloServlet implements Servlet {

  @Override
  public void init(ServletConfig config) throws ServletException {

  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    // HTTP 클라이언트가 name이란 이름으로 보내 온 값을 읽는다.
    String name = req.getParameter("name");

    // HTTP 클라이언트에게 보낼 콘텐트의 MIME 타입을 설정한다.
    res.setContentType("text/plain;charset=UTF-8");

    // HTTP 클라이언트에게 콘텐트를 출력할 도구를 준비한다.
    PrintWriter out = res.getWriter();

    // HTTP 클라이언트에게 콘텐트를 출력한다.
    out.printf("%s 님 환영합니다!", name);

  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {
  }

}
