package com.eomcs.mylist.controller.board;

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
public class BoardDeleteController extends HttpServlet {

  BoardService boardService;

  @Override
  public void init() throws ServletException {
    // BoardService 객체를 웹애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      board.setWriter(loginUser);

      boardService.delete(board);

      request.setAttribute("viewUrl", "redirect:list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
    }
  }
}
