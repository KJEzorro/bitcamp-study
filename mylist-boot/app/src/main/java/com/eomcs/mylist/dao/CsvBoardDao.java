package com.eomcs.mylist.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

public class CsvBoardDao {

  ArrayList boardList = new ArrayList();

  public CsvBoardDao() {
    try {
      BufferedReader in = new BufferedReader(new FileReader("boards.csv"));

      String csvStr;
      while ((csvStr = in.readLine()) != null) {
        boardList.add(Board.valueOf(csvStr)); 
      }
      in.close();
    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생");
    }
  }


  public void save() throws Exception {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.csv")));

    for (int i = 0; i < boardList.size(); i++) {
      Board board = (Board) boardList.get(i);
      out.println(board.toCsvString());
    }
    out.flush();
    out.close();
  }

  public int countAll() {
    return boardList.size();
  }

  public Object[] findAll() {
    return boardList.toArray();
  }

  public void insert(Board board) {
    boardList.add(board);
  }

  public Board findByNo(int no) {
    if (no < 0 || no >= boardList.size()) {
      return null;
    }
    return (Board) boardList.get(no);
  }

  public int update(int no, Board board) {
    if (no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.set(no, board);
    return 1;
  }

  public int delete(int no) {
    if (no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.remove(no);
    return 1;
  }





}











