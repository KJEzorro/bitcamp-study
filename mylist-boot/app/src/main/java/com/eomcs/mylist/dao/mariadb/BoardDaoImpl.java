package com.eomcs.mylist.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.dao.DaoException;
import com.eomcs.mylist.domain.Board;
// @Repository
// - 클래스에 이 애너테이션을 붙여 표시해 두면, Spring Boot가 실행될 때 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.

@Repository   
public class BoardDaoImpl implements BoardDao {

  @Autowired // => 스프링 부트가 보관하고 있는 객체 중에서 다음 타입의 객체가 있다면 주입해 줄 것을 지시하는 애노테이션.
  DataSource dataSource;

  @Autowired
  SqlSessionFactory sqlSessionFactory; // => Mybatis: 제공하는 SQL 실행 도구를 만들어 주는 객체.

  public BoardDaoImpl() {
    System.out.println("BoardDao 객체 생성");
  }

  @Override
  public int countAll() {
    try (Connection con = dataSource.getConnection(); 
        // DataSource에서 얻은 커넥션 객체는 close() 할 때 연결을 끊는 것이 아니라 DataSource에 반납된다. 
        PreparedStatement stmt = con.prepareStatement( 
            "select count(*) from ml_board");
        ResultSet rs = stmt.executeQuery()) {

      rs.next();
      return rs.getInt(1);
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public List<Board> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.selectList("BoardDao.sql1");
    }
  }

  @Override
  public int insert(Board board) {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt =
            con.prepareStatement("insert into ml_board(title,content) values(?,?)");) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public Board findByNo(int no) {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "select board_no,title,content,created_date,view_count from ml_board where board_no=?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("board_no"));
          board.setTitle(rs.getString("title"));
          board.setContent(rs.getString("content"));
          board.setCreatedDate(rs.getDate("created_date"));
          board.setViewCount(rs.getInt("view_count"));
          return board;
        } else {
          return null;
        }
      }
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int update(Board board) {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement( //
            "update ml_board set title=?,content=? where board_no=?")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "delete from ml_board where board_no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int increaseViewCount(int no) {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement( //
            "update ml_board set view_count=view_count + 1 where board_no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }  
}

