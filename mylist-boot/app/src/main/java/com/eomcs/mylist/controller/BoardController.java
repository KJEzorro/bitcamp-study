package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;

@RestController 
public class BoardController {

  // @Autowired
  // - 필드 선언부에 이 애너테이션을 붙여서 표시해 두면,
  //   Spring Boot가 BoardController 객체를 만들 때 BoardDao 구현체를 찾아 자동으로 주입한다.
  //   required = false 설정을 안하면 무조건 주입되어야 한다. 아니면 에러.
  //   @Autowired(required = false)
  @Autowired
  BoardDao boardDao;   

  public BoardController() {
    System.out.println("BoardController() 호출됨!");
  }

  @RequestMapping("/board/list")
  public Object list() {  
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    return boardDao.insert(board);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardDao.findByNo(no);
    if (board == null) {
      return "";
    }
    boardDao.increaseViewCount(no);
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(Board board) {
    return boardDao.update(board);
  }

  @RequestMapping("/board/delete")
  public Object delete(int no) {
    return boardDao.delete(no);
  }





}
