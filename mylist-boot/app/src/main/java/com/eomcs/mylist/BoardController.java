package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class BoardController {

  // Board 객체 목록을 저장할 메모리를 준비한다.
  ArrayList boardList = new ArrayList();



  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray();
  }


  @RequestMapping("/board/add")
  public Object add(Board board) {

    board.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
    boardList.add(board);
    return boardList.size;
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index == -1 || index >= boardList.size) {
      return "";
    }
    Board board = (Board)boardList.list[index];
    board.viewCount++;
    return boardList.list[index];
  }



  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index == -1 || index >= boardList.size) {
      return 0;
    }


    Board old = (Board)boardList.list[index];
    board.viewCount = old.viewCount;
    board.createdDate = old.createdDate;
    return boardList.set(index, board) == null ? 0 : 1;
  }


  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index == -1 || index >= boardList.size) {
      return "";
    }
    return boardList.remove(index) == null ? 0 : 1; 
  }

}




