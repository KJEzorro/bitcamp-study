package com.eomcs.mylist.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/detail") 
public class BoardDetailServlet extends HttpServlet {

  BoardService boardService;

  @Override
  public void init() throws ServletException {
    // BoardService 객체를 웹애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    try {
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
      out.println("<h1>게시글 상세</h1>");

      int no = Integer.parseInt(req.getParameter("no"));
      Board board = boardService.get(no);

      out.println("<form action='update' method='post'>");
      out.printf("번호: <input name=\"no\" type=\"text\" value='%d' readonly><br>\n", board.getNo());
      out.printf("제목*: <input name=\"title\" type=\"text\" value='%s'><br>\n", board.getTitle());
      out.printf("내용*: <textarea name=\"content\" cols=\"50\" rows=\"10\">%s</textarea><br>\n", board.getContent());
      out.printf("작성자: <span>%s</span><br>\n", board.getWriter().getName());
      out.printf("조회수: <span>%d</span><br>\n", board.getViewCount());
      out.printf("등록일: <span>%s</span><br>\n", board.getCreatedDate());
      out.println("별표(*) 항목은 필수 입력입니다.<br>");
      out.println("<button>변경</button>");
      out.println("<button id='delete-btn' type=\"button\">삭제</button>");
      out.println("<button id='cancel-btn' type=\"button\">취소</button>");
      out.println("</form>");
      out.println("</div>");

      out.println("<div id=\"footer\">");
      req.getRequestDispatcher("/footer").include(req, resp);
      out.println("</div>");

      out.println("</div>");
      out.println("<script>");
      out.println("document.querySelector('#delete-btn').onclick = () => {");
      out.println("  location.href = 'delete?no=' + document.querySelector('input[name=no]').value;");
      out.println("}");
      out.println("document.querySelector('#cancel-btn').onclick = () => {");
      out.println("  location.href = 'list';");
      out.println("}");
      out.println("</script>");
      out.println("</body>");
      out.println("</html>");

    } catch (Exception e) {
      req.setAttribute("exception", e);
      // 포워드 하기 전에 출력한 콘텐트가 있다면 모두 버리고 다른 서블릿에게 책임을 위임한다.
      req.getRequestDispatcher("/error").forward(req, resp);
    }
  }
}
