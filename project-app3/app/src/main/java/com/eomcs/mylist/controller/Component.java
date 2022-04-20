package com.eomcs.mylist.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 현재 정의하는 애노테이션은 오직 클래스나 인터페이스에만 붙일 수 있게 제한한다.
@Retention(RetentionPolicy.RUNTIME) // 현재 정의하는 애노테이션 정보를 JVM 실행 중에 추출할 수 있게 허락한다.
public @interface Component { // 객체를 자동 생성하고 싶을 때 붙이는 애노테이션

}
