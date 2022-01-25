package com.eomcs.mylist.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.eomcs.mylist.domain.Board;
//@Repository
public class CsvBoardDao extends AbstractBoardDao {  

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


  @Override
  protected void save() throws Exception {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.csv")));

    for (int i = 0; i < boardList.size(); i++) {
      Board board = (Board) boardList.get(i);
      out.println(board.toCsvString());
    }
    out.flush();
    out.close();
  }

}











