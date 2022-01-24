package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.CsvBoardDao;
import com.eomcs.mylist.domain.Board;

@RestController 
public class BoardController {

  CsvBoardDao boardDao = new CsvBoardDao();

  public BoardController() {
    System.out.println("BoardController() 호출됨!");
  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {

    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardDao.insert(board);
    return boardDao.countAll();
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    Board board = boardDao.findByNo(index);
    if (board == null) {
      return "";
    }
    board.setViewCount(board.getViewCount() + 1);
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    Board old = boardDao.findByNo(index);

    if (old == null) {
      return 0;
    }

    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());
    return boardDao.update(index, board);

  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    return boardDao.delete(index);
  }

  @RequestMapping("/board/save")
  public Object save() throws Exception {
    boardDao.save();
    return boardDao.countAll();
  }
}
