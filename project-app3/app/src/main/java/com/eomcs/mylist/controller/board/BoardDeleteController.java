package com.eomcs.mylist.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.controller.Component;
import com.eomcs.mylist.controller.RequestMapping;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@Component("/board/delete")
public class BoardDeleteController {

  BoardService boardService;

  public BoardDeleteController(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    board.setWriter(loginUser);

    boardService.delete(board);

    return "redirect:list";

  }
}
