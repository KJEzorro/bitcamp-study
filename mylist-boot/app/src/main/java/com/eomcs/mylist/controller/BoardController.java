package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController 
public class BoardController {

  ArrayList boardList = new ArrayList();

  public BoardController() {
    System.out.println("BoardController() 호출됨!");

    //  FileInputStream in = new FileInputStream("boards.data");
    //  BufferedInputStream in2 = new BufferedInputStream(in);
    //  DataInputStream in3 = new DataInputStream(in2);
    try {
      BufferedReader in = new BufferedReader(new FileReader("boards.json"));

      // JSON 문자열을 다룰 객체 준비
      ObjectMapper mapper = new ObjectMapper();




      // 1) JSON 파일에서 문자열을 읽어온다.
      // => 읽어 온 문자열은 배열 형식이다.
      String jsonStr = in.readLine();

      // 2) JSON 문자열을 가지고 자바 객체를 생성한다.
      // => 배열 형식의 JSON 문자열에서 Board의 배열 객체를 생성한다.
      Board[] boards = mapper.readValue(jsonStr, Board[].class);

      
      // 3) 배열 객체를 ArrayList 에 저장한다.
      for (Board board : boards) {
        boardList.add(board);
      }

      in.close();

    } catch (Exception e) {
      System.out.println("게시판 데이터 로딩하는 중 오류 발생");
      e.printStackTrace();
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
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.json")));

    // JSON 형식의 문자열을 다룰 객체를 준비한다.
    ObjectMapper mapper = new ObjectMapper();

    // 1) 객체를 JSON 형식의 문자열로 생성한다.
    // => ArrayList 에서 Board 배열을 꺼낸 후 JSON 문자열로 만든다.
    String jsonStr = mapper.writeValueAsString(boardList.toArray());

    // 2) JSON 형식으로 바꾼 문자열을 파일로 출력한다.
    out.println(jsonStr);

    out.close();
    return boardList.size();
  }
}




