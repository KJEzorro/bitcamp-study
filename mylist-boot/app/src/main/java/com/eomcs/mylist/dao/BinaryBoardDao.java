package com.eomcs.mylist.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

//@Repository
public class BinaryBoardDao implements BoardDao {  

  //variables initializer
  String filename = "boards.bin";
  ArrayList boardList = new ArrayList();  // 변수 선언 = 변수를 만들라는 명렁어.

  public BinaryBoardDao() {
    // super();
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


  private void save() throws Exception {
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











