package com.eomcs.mylist.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.controller.Component;
import com.eomcs.mylist.controller.RequestMapping;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@Component("/board/add")
public class BoardAddController {

  BoardService boardService;

  public BoardAddController(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      return "/jsp/board/form.jsp";
    }

    Board board = new Board();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    board.setWriter(loginUser);

    boardService.add(board);

    return "redirect:list";

  }
}












