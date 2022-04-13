package com.eomcs.mylist.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/error") 
public class ErrorServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // GET, POST 요청 모두에 대응할 수 있도록 service()를 오버라이딩 한다.

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset=\"UTF-8\">");
    out.println("  <title>MyList!</title>");
    out.println("  <link href=\"/css/common.css\" rel=\"stylesheet\">");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class=\"container\">");
    out.println("<div id=\"header\">");
    req.getRequestDispatcher("/header").include(req, resp);
    out.println("</div>");
    out.println("<div id=\"sidebar\">");
    req.getRequestDispatcher("/sidebar").include(req, resp);
    out.println("</div>");
    out.println("<div id=\"content\">");
    out.println("<h1>서버 오류!</h1>");

    Exception e = (Exception) req.getAttribute("exception");
    out.printf("<p>%s</p>\n", e.getMessage());

    out.println("</div>");
    out.println("<div id=\"footer\">");
    req.getRequestDispatcher("/footer").include(req, resp);
    out.println("</div>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }
}






