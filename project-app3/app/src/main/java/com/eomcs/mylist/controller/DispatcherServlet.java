package com.eomcs.mylist.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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

    String controllerPath = request.getPathInfo();

    try {
      response.setContentType("text/html; charset=UTF-8");
      RequestDispatcher 요청배달자 = request.getRequestDispatcher(controllerPath);
      요청배달자.include(request, response);

      Exception exception = (Exception) request.getAttribute("exception"); 
      if (exception != null) {
        throw exception;
      }

      String viewUrl = (String) request.getAttribute("viewUrl");
      request.getRequestDispatcher(viewUrl).include(request, response);

    } catch (Exception e) {
      if (request.getAttribute("exception") == null) {
        request.setAttribute("exception", e);
      }
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }
}
