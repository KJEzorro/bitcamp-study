package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {

  ArrayList boardList = new ArrayList();

  public BoardController() throws Exception {
    System.out.println("BoardController() 호출됨!");

    //  FileInputStream in = new FileInputStream("boards.data");
    //  BufferedInputStream in2 = new BufferedInputStream(in);
    //  DataInputStream in3 = new DataInputStream(in2);
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("boards.ser2")));

      // 1) 객체가 각각 따로 serialize 되었을 경우, 다음과 같이 객체 단위로 읽으면 되고,
      //    while (true) { 
      //      try {
      //        Board board = (Board)in.readObject();
      //        boardList.add(board); 
      //
      //      } catch (Exception e) {
      //        break;
      //      }
      //    }

      // 2) 목록이 통째로 serialize 되었을 경우, 한 번에 목록을 읽으면 된다.
      boardList = (ArrayList)in.readObject(); // 단 기존의 생성한 ArrayList 객체는 버린다. 

      in.close();
    } catch (Exception e) {
      System.out.println("게시판 데이터 로딩하는 중 오류 발생");
    }
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
    // 1) 주 작업 객체 준비
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("boards.ser2")));

    // 1) 다음과 같이 목록에 들어 있는 객체를 한 개씩 순차적으로 serialize 할 수도 있고,
    //    Object[] arr = boardList.toArray();
    //    for (Object obj : arr) {
    //      out.writeObject(obj);
    //    }

    // 2) 다음과 같이 목록 자체를 serialize 할 수도 있다.
    out.writeObject(boardList);

    out.close();
    return boardList.size();
  }
}




