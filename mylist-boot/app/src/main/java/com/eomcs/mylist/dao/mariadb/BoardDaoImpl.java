package com.eomcs.mylist.dao.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.App;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.dao.DaoException;
import com.eomcs.mylist.domain.Board;
// @Repository
// - 클래스에 이 애너테이션을 붙여 표시해 두면, Spring Boot가 실행될 때 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.

@Repository   
public class BoardDaoImpl implements BoardDao {

  public BoardDaoImpl() {
    System.out.println("BoardDao 객체 생성");
  }

  @Override
  public int countAll() {
    try (PreparedStatement stmt = App.con.prepareStatement( 
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
    try (PreparedStatement stmt = App.con.prepareStatement( 
        "select board_no,title,created_date,view_count from ml_board order by board_no desc");
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<Board> arr = new ArrayList<>();
      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setCreatedDate(rs.getDate("created_date"));
        board.setViewCount(rs.getInt("view_count"));
        arr.add(board);
      }
      return arr;
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int insert(Board board) {
    try (PreparedStatement stmt =
        App.con.prepareStatement("insert into ml_board(title,content) values(?,?)");) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public Board findByNo(int no) {
    try (PreparedStatement stmt = App.con.prepareStatement(
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
    try (PreparedStatement stmt = App.con.prepareStatement( //
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
    try (PreparedStatement stmt = App.con.prepareStatement(
        "delete from ml_board where board_no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int increaseViewCount(int no) {
    try (PreparedStatement stmt = App.con.prepareStatement( //
        "update ml_board set view_count=view_count + 1 where board_no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }  
}











