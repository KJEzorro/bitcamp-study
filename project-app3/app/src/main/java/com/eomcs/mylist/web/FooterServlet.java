package com.eomcs.mylist.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/footer") 
public class FooterServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // GET, POST 요청 모두에 대응할 수 있도록 service() 를 오버라이딩 한다.

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<style>");
    out.println("#company-title {");
    out.println("  font-size: 1.2em;");
    out.println("  font-weight: bold;");
    out.println("}");
    out.println("#company-address {");
    out.println("  display: inline-block;");
    out.println("  width: calc(100% - 100px); ");
    out.println("  text-align: center; ");
    out.println("}");
    out.println("</style>");
    out.println("<span id=\"company-title\">비트캠프</span> ");
    out.println("<address id=\"company-address\">서울 강남구 강남대로94길 20, 삼오빌딩</address>  ");
  }
}






