package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

@RestController
public class BoardController {

  @Autowired
  BoardService boardService;

  @RequestMapping("/board/list")
  public Object list() {
    return boardService.list();
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    return boardService.add(board);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardService.get(no);
    if (board == null) {
      return "";
    }
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(Board board) {
    return boardService.update(board);
  }

  @RequestMapping("/board/delete")
  public Object delete(int no) {
    return boardService.delete(no);
  }
}
