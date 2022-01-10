package com.eomcs.mylist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.io.FileWriter2;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {

  // Board 객체 목록을 저장할 메모리를 준비한다.
  ArrayList boardList = new ArrayList();

  public BoardController() throws Exception{

    System.out.println("BoardController() 호출됨");

    com.eomcs.io.FileReader2 in = new com.eomcs.io.FileReader2("boards.csv");

    String line;
    while ((line = in.readLine()).length() != 0) { // 빈 줄을 리턴받았으면 읽기를 종료한다.
      boardList.add(Board.valueOf(line)); // 파일에서 읽은 CSV 데이터로 객체를 초기화시킨후 목록에 등록한다.

    }
    in.close();
  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {

    board.setCreatedDate(nowTime());
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
    board.setCreatedDate(nowTime());


    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }
    return boardList.remove(index) == null ? 0 : 1;
  }

  String nowTime() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));

  }


  @RequestMapping("/board/save")
  public Object save() throws Exception{
    // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.
    FileWriter2 out = new FileWriter2("boards.csv");

    Object[] arr = boardList.toArray();
    for (Object obj : arr) {
      Board board = (Board) obj;
      out.println(board.toCsvString());
    }
    out.close();
    return arr.length;
  }
}




