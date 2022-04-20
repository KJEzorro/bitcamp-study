package com.eomcs.mylist.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.controller.Component;
import com.eomcs.mylist.controller.RequestMapping;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

@Component("/board/detail")
public class BoardDetailController {

  BoardService boardService;

  public BoardDetailController(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    Board board = boardService.get(no);
    request.setAttribute("board", board);

    return "/jsp/board/detail.jsp";

  }
}
