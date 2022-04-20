package com.eomcs.mylist.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
      Object pageController= 애플리케이션보관소.getAttribute(controllerPath); // 예) /board/list

      // 페이지 컨트롤러에서 @RequestMapping이 붙은 메서드를 알아낸다.
      Class<?> classInfo = pageController.getClass();
      Method[] methods = classInfo.getDeclaredMethods();

      Method requestHandler = null;
      for (Method m : methods) {
        RequestMapping anno = m.getAnnotation(RequestMapping.class);
        if (anno != null) {
          requestHandler = m;
          break;
        }
      }


      String viewUrl = (String) requestHandler.invoke(pageController, request, response);


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
}
