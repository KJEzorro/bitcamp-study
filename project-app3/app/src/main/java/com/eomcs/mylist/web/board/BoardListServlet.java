package com.eomcs.mylist.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/list") 
public class BoardListServlet extends HttpServlet {

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
    out.println("<h1>게시글</h1>");
    out.println("<a href=\"?content=/board/form.html\">새 게시글</a>");
    out.println("<table id=\"x-board-table\" border=\"1\">");
    out.println("<thead>");
    out.println("  <tr>");
    out.println("    <th>번호</th>");
    out.println("    <th>제목</th>");
    out.println("    <th>작성자</th>");
    out.println("    <th>조회수</th>");
    out.println("    <th>등록일</th>");
    out.println("  </tr>");
    out.println("</thead>");
    out.println("<tbody>");

    List<Board> boards = boardService.list();
    for (Board board : boards) {
      out.println("  <tr>");
      out.printf("    <td>%d</td>\n", board.getNo());
      out.printf("    <td><a href='detail?no=%d'>%s</a></td>\n", board.getNo(), board.getTitle());
      out.printf("    <td>%s</td>\n", board.getWriter().getName());
      out.printf("    <td>%d</td>\n", board.getViewCount());
      out.printf("    <td>%s</td>\n", board.getCreatedDate());
      out.println("  </tr>");
    }

    out.println("</tbody>");
    out.println("</table>");
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

    out.println("</body>");
    out.println("</html>");

  }
}






