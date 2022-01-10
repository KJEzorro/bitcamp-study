package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.io.FileReader2;
import com.eomcs.io.FileWriter2;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {

  ArrayList boardList = new ArrayList();

  public BoardController() throws Exception {
    System.out.println("BoardController() 호출됨!");
    FileReader2 in = new FileReader2("boards.csv");
    String line;
    while ((line = in.readLine()).length() != 0) {
      boardList.add(Board.valueOf(line)); 
    }

    in.close();
  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {

    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardList.add(board);
    return boardList.size();
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= boardList.size()) {
      return "";
    }
    Board board = (Board) boardList.get(index);
    board.setViewCount(board.getViewCount() + 1);

    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }

    Board old = (Board) boardList.get(index);
    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());

    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }
    return boardList.remove(index) == null ? 0 : 1;
  }

  @RequestMapping("/board/save")
  public Object save() throws Exception {
    FileWriter2 out = new FileWriter2("boards.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.

    Object[] arr = boardList.toArray();
    for (Object obj : arr) {
      Board board = (Board) obj;
      out.println(board.toCsvString());
    }

    out.close();
    return arr.length;
  }
}




