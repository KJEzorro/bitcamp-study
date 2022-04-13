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
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {

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
    out.println("<style>");

    out.println("#login-btn {");
    out.println("  position: absolute;");
    out.println("  right: 10px;");
    out.println("}");

    out.println("#logout-btn {");
    out.println("  position: absolute;");
    out.println("  right: 10px;");
    out.println("}");

    out.println("#app-title {");
    out.println("  font-size: 1.5em;");
    out.println("  font-weight: bold;");
    out.println("  font-style: none;");
    out.println("  color: white;");
    out.println("} ");

    out.println("#user-name {");
    out.println("  position: absolute;");
    out.println("  right: 90px;");
    out.println("}");
    out.println("</style>");

    out.println("<a href=\"/index.html\"><span id=\"app-title\">MyList</span></a> ");
    out.println("<button id=\"login-btn\" type=\"button\" class=\"not-login\">로그인</button>");
    out.println("<span id=\"user-name\" class=\"login\"></span>");
    out.println("<button id=\"logout-btn\" type=\"button\" class=\"login\">로그아웃</button>  ");
    out.println("</div>");

    out.println("<div id=\"sidebar\">");
    out.println("<style>");
    out.println("h1.sidebar {");
    out.println("  font-size: 1.2em;");
    out.println("}");
    out.println("</style>");

    out.println("<h1 class=\"sidebar\">제목</h1>");
    out.println("<div class=\"sidebar\">");
    out.println("<ul>");
    out.println("  <li>내용1</li>");
    out.println("  <li>내용2</li>");
    out.println("  <li>내용3</li>");
    out.println("</ul>");
    out.println("</div>  ");
    out.println("</div>");

    out.println("<div id=\"content\">");
    out.println("<h1>게시글 등록</h1>");

    out.println("<form method='post'>");
    out.println("제목*: <input name=\"title\" type=\"text\"><br>");
    out.println("내용*: <textarea name=\"content\" cols=\"50\" rows=\"10\"></textarea><br>");
    out.println("별표(*) 항목은 필수 입력입니다.<br>");
    out.println("<button>등록</button>");
    out.println("<button id='cancel-btn' type=\"button\">취소</button>");
    out.println("</form>");
    out.println("</div>");

    out.println("<div id=\"footer\">");
    out.println("<style>");
    out.println("#company-title {");
    out.println("  font-size: 1.2em;");
    out.println("  font-weight: bold;");
    out.println("}");

    out.println("#company-address {");
    out.println("  display: inline-block;");
    out.println("  width: calc(100% - 100px); ");
    out.println("  text-align: center; ");
    out.println("}");
    out.println("</style>");

    out.println("<span id=\"company-title\">비트캠프</span> ");
    out.println("<address id=\"company-address\">서울 강남구 강남대로94길 20, 삼오빌딩</address>  ");
    out.println("</div>");

    out.println("</div>");
    out.println("<script>");
    out.println("document.querySelector('#cancel-btn').onclick = () => {");
    out.println("  location.href = 'list';");
    out.println("}");
    out.println("</script>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // 웹브라우저가 POST 요청으로 문자열을 보낼 때 어떤 문자집합으로 인코딩 했는지 알려줘야 한다.
    // 그래야만 getParameter() 메서드에서 웹브라우저가 보낸 파라미터 값을 올바르게 꺼낼 수 있다.
    // 즉 웹브라우저에서 웹서버에게 데이터를 보낼 때 UTF-8 로 인코딩 해서 보낸다.
    // 그렇게 인코딩 해서 보낸 문자열을 자바에서 사용하는 UTF-16 으로 바꿔서 리턴하는 것이다.
    // 주의!
    // 반드시 getParaemeter() 호출하기 전에 설정해야 한다.
    // 단 한 번이라도 getParameter() 호출한 후 설정하게 되면 이 설정은 무시된다.
    req.setCharacterEncoding("UTF-8");

    Board board = new Board();
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));

    Member loginUser = (Member) req.getSession().getAttribute("loginUser");
    board.setWriter(loginUser);

    boardService.add(board);

    resp.sendRedirect("list");
  }
}
