package com.eomcs.mylist.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {
  String value(); // 요청 파라미터에 이름을 설정
  String defaultValue() default ""; // 해당 이름의 요청 파라미터 값이 없을 때 사용할 기본 값을 설정하는 프로퍼티
}
