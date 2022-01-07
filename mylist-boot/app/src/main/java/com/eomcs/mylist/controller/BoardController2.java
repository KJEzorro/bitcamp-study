package com.eomcs.mylist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board2;
import com.eomcs.util.ArrayList2;


@RestController 
public class BoardController2 {

  ArrayList2 boardList2 = new ArrayList2();


  @RequestMapping("/board2/list")
  public Object list() {
    return boardList2.toArray(); 
  }

  @RequestMapping("/board2/add")
  public Object add(Board2 board) {

    board.setCreatedDate(nowTime());
    boardList2.add(board);
    return boardList2.size();
  }


  @RequestMapping("/board2/get")
  public Object get(int index) {
    if (index < 0 || index >= boardList2.size()) {
      return "";
    }
    Board2 board = (Board2) boardList2.get(index);
    board.setViewCount(board.getViewCount() + 1);
    return board;
  }

  @RequestMapping("/board2/update")
  public Object update(int index, Board2 board) {
    if (index < 0 || index >= boardList2.size()) {
      return 0;
    }

    Board2 old = (Board2) boardList2.get(index);
    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());

    return boardList2.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board2/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList2.size()) {
      return 0;
    }
    boardList2.remove(index);
    return 1;
  }

  String nowTime() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));
  }
}




