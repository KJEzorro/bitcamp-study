package com.eomcs.mylist.web.board;

import java.io.IOException;
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
@WebServlet("/board/delete") 
public class BoardDeleteServlet extends HttpServlet {

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
      Board board = new Board();
      board.setNo(Integer.parseInt(req.getParameter("no")));

      Member loginUser = (Member) req.getSession().getAttribute("loginUser");
      board.setWriter(loginUser);

      boardService.delete(board);

      resp.sendRedirect("list");

    } catch (Exception e) {
      req.setAttribute("exception", e);
      // 포워드 하기 전에 출력한 콘텐트가 있다면 모두 버리고 다른 서블릿에게 책임을 위임한다.
      req.getRequestDispatcher("/error").forward(req, resp);
    }
  }
}
