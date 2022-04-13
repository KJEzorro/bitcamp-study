package com.eomcs.mylist.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    // POST 요청의 경우,
    // 다음 필터나 서블릿을 실행하기 전에 파라미터 값의 인코딩을 UTF-8로 지정한다.

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    if (httpRequest.getMethod().equals("POST")) {
      // 웹브라우저가 POST 요청으로 문자열을 보낼 때 어떤 문자집합으로 인코딩 했는지 알려줘야 한다.
      // 그래야만 getParameter() 메서드에서 웹브라우저가 보낸 파라미터 값을 올바르게 꺼낼 수 있다.
      // 웹브라우저는 웹서버에게 데이터를 보낼 때 UTF-8 로 인코딩 해서 보낸다.
      // getParameter()는 UTF-8로 인코딩된 보낸 문자열을 자바에서 사용하려면 UTF-16 으로 바꿔 리턴한다.
      // 주의!
      // 반드시 getParaemeter() 호출하기 전에 설정해야 한다. 
      // 단 한 번이라도 getParameter() 호출한 후 설정하게 되면 이 설정은 무시된다.
      httpRequest.setCharacterEncoding("UTF-8");
    }

    // 현재 필터 다음에 연결된 필터를 실행시킨다.
    // 만약 다음에 실행할 필터가 없다면 내부적으로 최종 목적지인 서블릿을 실행한다.
    chain.doFilter(request, response);



  }


}
