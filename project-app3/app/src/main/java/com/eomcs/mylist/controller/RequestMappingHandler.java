package com.eomcs.mylist.controller;

import java.lang.reflect.Method;
import lombok.Data;
import lombok.experimental.Accessors;

// 역할
// -@RequestMapping 이 붙은 메서드의 정보를 저장하는 객체
// 
@Data
@Accessors(chain = true)
public class RequestMappingHandler {

  Object obj;
  Method method;
  String pathInfo;

}
