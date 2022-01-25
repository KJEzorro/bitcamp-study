package com.eomcs.mylist.dao;

import java.io.File;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
// @Repository
// - 클래스에 이 애너테이션을 붙여 표시해 두면, Spring Boot가 실행될 때 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.
//@Repository   
public class JsonBoardDao implements BoardDao {  

  //variables initializer
  String filename = "boards.json";
  ArrayList boardList = new ArrayList();  

  public JsonBoardDao() {
    // super();
    try {
      ObjectMapper mapper = new ObjectMapper();
      boardList.addAll(mapper.readValue(new File(filename), Board[].class));

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생");
    }
  }


  private void save() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), boardList.toArray());
  }

  @Override
  public int countAll() {
    return boardList.size();
  }

  @Override
  public Object[] findAll() {
    return boardList.toArray();
  }

  @Override
  public void insert(Board board) throws Exception {
    boardList.add(board);
    save();
  }

  @Override
  public Board findByNo(int no) {
    if (no < 0 || no >= boardList.size()) {
      return null;
    }
    return (Board) boardList.get(no);
  }

  @Override
  public int update(int no, Board board) throws Exception {
    if (no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.set(no, board);
    save();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.remove(no);
    this.save();
    return 1;
  }

  @Override
  public void increaseViewCount(int no) throws Exception {
    Board board = findByNo(no);
    board.setViewCount(board.getViewCount() + 1);
    save();

  }

}











