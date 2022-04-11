package com.eomcs.app3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet({"/hello3", "/hello4", "/hello5"}) // 서블릿 컨테이너에게 이 클래스가 /hello 요청을 처리하는 서블릿임을 알려준다.
public class Hello3Servlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    System.out.println("service() 호출");

    // HTTP 클라이언트가 name이란 이름으로 보내 온 값을 읽는다.
    String name = req.getParameter("name");

    // HTTP 클라이언트에게 보낼 콘텐트의 MIME 타입을 설정한다.
    resp.setContentType("text/plain;charset=UTF-8");

    // HTTP 클라이언트에게 콘텐트를 출력할 도구를 준비한다.
    PrintWriter out = resp.getWriter();

    // HTTP 클라이언트에게 콘텐트를 출력한다.
    out.printf("%s 님 환영합니다!", name);

  }
}
