package com.eomcs.mylist.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.eomcs.mylist.interceptor.AuthInterceptor;

// @Configuration 애노테이션의 용도
// 다음 클래스는 설정에 관련된 일을 하는 클래스임을 선언한다.
// 스프링부트는 이 애노테이션이 붙은 클래스에 대해 
// 관련 메서드를 호출하여 내부 설정에 반영한다.
@Configuration 
public class MvcConfiguration implements WebMvcConfigurer {
  // WebMvcConfigurer 인터페이스
  // => 이 규칙에 따라 메서드를 작성하면
  //    스프링부트는 해당 메서드를 호출하여 그 메서드가 요구하는대로 설정을 수행한다.


  // 인터셉터를 추가하고 싶다면 다음 메서드를 규칙에 따라 정의하라
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    System.out.println("MvcConfiguration.addInterceptors() 호출됨");
    // 이 메서드가 정의되어 있다면,
    // 스프링부트는 이 메서드를 호출하여 추가할 인터셉터의 정보를 InterceptorRegistry로 받는다.
    registry.addInterceptor(new AuthInterceptor())
    .addPathPatterns("/**/add*", "/**/pudate*", "/**/delete*");
  }

}
