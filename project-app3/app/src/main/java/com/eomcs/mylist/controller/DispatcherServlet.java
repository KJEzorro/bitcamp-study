package com.eomcs.mylist.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/app/*")
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String controllerPath = request.getPathInfo(); // 예) /board/list

    try {
      response.setContentType("text/html; charset=UTF-8");

      // 애플리케이션 보관소에서 페이지 컨트롤러를 찾는다.
      ServletContext 애플리케이션보관소 = request.getServletContext();
      RequestMappingHandler requestMappingHandler = (RequestMappingHandler) 애플리케이션보관소.getAttribute(controllerPath); // 예) /board/list

      // 페이지 컨트롤러가 작업한 결과를 담을 맵 객체를 준비한다.
      HashMap<String, Object> model = new HashMap<>();

      // request handler가 원하는 파라미터 값을 준비한다.
      Object[] args = prepareArguments(
          requestMappingHandler.getMethod(),
          request,
          response,
          model);



      // request Handler를 호출할 때 위에서 준비한 파라미터 값을 전달한다.
      String viewUrl = (String) requestMappingHandler.getMethod().invoke(requestMappingHandler.getObj(), args);

      // request handler가 작업한 결과를 JSP가 사용할 수 있도록 ServletRequest 보관소에 옮긴다.
      if (model.size() > 0) {
        Set<Entry<String,Object>> values = model.entrySet();
        for (Entry<String,Object> value : values) {
          request.setAttribute(value.getKey(), value.getValue());
        }
      }

      if (viewUrl.startsWith("redirect:")) { // 예) redirect:list
        response.sendRedirect(viewUrl.substring(9)); // 예) list
      } else {
        request.getRequestDispatcher(viewUrl).include(request, response);
      }

    } catch (Exception e) {
      if (request.getAttribute("exception") == null) {
        request.setAttribute("exception", e);
      }
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }

  private Object[] prepareArguments(
      Method method,
      HttpServletRequest request,
      HttpServletResponse response,
      Map<String,Object> model) {

    // 메서드에 선언된 파라미터 목록을 알아낸다.
    java.lang.reflect.Parameter[] params = method.getParameters();

    // 파라미터에 전달할 값을 담을 객체 배열을 준비한다.
    Object[] args = new Object[params.length];

    // 파라미터를 분석하여 값을 준비한다.
    for (int i = 0; i < params.length; i++) {
      Class<?> paramType = params[i].getType();
      if (paramType == HttpServletRequest.class) {
        args[i] = request;
      }
      else if (paramType == HttpServletResponse.class) {
        args[i] = response;
      }
      else if (paramType == HttpSession.class) {
        args[i] = request.getSession();
      }
      else if (paramType == HashMap.class) {
        args[i] = model;
      }
      else if (paramType == Map.class) {
        args[i] = model;
      } else {
        args[i] = getRequestParameter(request, params[i]);
      }
    }

    return args;

  }

  private Object getRequestParameter(HttpServletRequest request, Parameter parameter) {

    // request handler의 파라미터에서 @RequestParam 을 추출한다.
    RequestParam anno = parameter.getAnnotation(RequestParam.class);

    // @RequestParam 에서 이름을 추출한다.
    String name = anno.value();

    // @RequestParam에 설정된 이름을 가지고 요청 파라미터 값을 꺼낸다.
    String value = request.getParameter(name);
    // 해당 이름의 파라미터 값이 없으면 @RequestParam의 defaultValue 프로퍼티 값을 대신 사용한다.
    if (value  == null) {
      value = anno.defaultValue();
    }

    // String 값을 파라미터가 원하는 타입으로 형변환한다.
    if (parameter.getType() == String.class) {
      return value;
    } 
    else if (parameter.getType() == byte.class) {
      return Byte.parseByte(value);
    } 
    else if (parameter.getType() == short.class) {
      return Short.parseShort(value);
    }
    else if (parameter.getType() == int.class) {
      return Integer.parseInt(value);
    }
    else if (parameter.getType() == long.class) {
      return Long.parseLong(value);
    }
    else if (parameter.getType() == float.class) {
      return Float.parseFloat(value);
    }
    else if (parameter.getType() == double.class) {
      return Double.parseDouble(value);
    }
    else if (parameter.getType() == char.class) {
      return value.charAt(0);
    }
    else if (parameter.getType() == boolean.class) {
      return Boolean.parseBoolean(value);
    } else {
      throw new RuntimeException("파라미터 값을 변환할 수 없습니다.");
    }




  }
}




































