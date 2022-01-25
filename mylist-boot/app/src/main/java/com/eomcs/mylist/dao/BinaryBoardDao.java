package com.eomcs.mylist.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import com.eomcs.mylist.domain.Board;



// 인터페이스를 직접 구현하는 대신에 AbstractBoardDao를 상속 받는다.
//@Repository
public class BinaryBoardDao extends AbstractBoardDao {  

  //variables initializer
  String filename = "boards.bin";

  public BinaryBoardDao() {
    try {
      DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

      // 저장된 데이터 개수를 읽어 온다.
      int len = in.readInt();

      // 게시글 개수만큼 읽는다.
      for (int i = 0; i < len; i++) {
        Board board = new Board();
        board.setTitle(in.readUTF());
        board.setContent(in.readUTF());
        board.setViewCount(in.readInt());
        board.setCreatedDate(Date.valueOf(in.readUTF()));

        boardList.add(board); 
      }
      in.close();
    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생");
    }
  }


  @Override
  protected void save() throws Exception {
    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));

    // 게시글 개수를 먼저 출력한다.
    out.writeInt(boardList.size());

    // 게시글을 순차적으로 출력한다.
    for (int i = 0; i < boardList.size(); i++) {
      Board board = (Board) boardList.get(i);
      out.writeUTF(board.getTitle());
      out.writeUTF(board.getContent());
      out.writeInt(board.getViewCount());
      out.writeUTF(board.getCreatedDate().toString());
    }
    out.flush();
    out.close();
  }


}











