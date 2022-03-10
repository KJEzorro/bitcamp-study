package com.eomcs.mylist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Board;
// @Repository
// - 클래스에 이 애너테이션을 붙여 표시해 두면, Spring Boot가 실행될 때 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.

@Repository   
public class JdbcBoardDao implements BoardDao {

  public JdbcBoardDao() {
    System.out.println("JdbcBoardDao 객체 생성");
  }

  @Override
  public int countAll() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Object[] findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int insert(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt =
            con.prepareStatement("insert into ml_board(title,content) values(?,?)");) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());

      return stmt.executeUpdate();
    }
  }

  @Override
  public Board findByNo(int no) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int update(int no, Board board) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(int no) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void increaseViewCount(int no) throws Exception {
    // TODO Auto-generated method stub

  }  


}











