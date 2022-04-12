package com.eomcs.mylist.service.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

public class DefaultBoardService implements BoardService {

  SqlSessionFactory sqlSessionFactory;

  public DefaultBoardService(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int add(Board board) {
    // 주의!
    // - 스레드 마다 SqlSession이 구분되어야 한다. 즉 클라이언트 간의 트랜잭션이 분리되어야 한다.
    // - 따라서 스레드가 서비스 메서드를 호출하는 시점에서 SqlSession을 얻어 DAO를 준비해야 한다.
    // 
    try (SqlSession session = sqlSessionFactory.openSession();) {
      BoardDao boardDao = session.getMapper(BoardDao.class);
      int count = boardDao.insert(board);
      session.commit();
      return count;

    } catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  public List<Board> list() {
    SqlSession session = sqlSessionFactory.openSession();
    BoardDao boardDao = session.getMapper(BoardDao.class);
    return boardDao.findAll();
  }

  @Override
  public Board get(int no) {
    try (SqlSession session = sqlSessionFactory.openSession();) {
      BoardDao boardDao = session.getMapper(BoardDao.class);
      Board board = boardDao.findByNo(no);
      if (board != null) {
        boardDao.increaseViewCount(no);
      }
      session.commit();
      return board;

    } catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  public int update(Board board) {
    try (SqlSession session = sqlSessionFactory.openSession();) {
      BoardDao boardDao = session.getMapper(BoardDao.class);
      int count = boardDao.update(board);
      session.commit();
      return count;

    } catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  public int delete(Board board) {
    try (SqlSession session = sqlSessionFactory.openSession();) {
      BoardDao boardDao = session.getMapper(BoardDao.class);
      int count = boardDao.delete(board);
      session.commit();
      return count;

    } catch (RuntimeException e) {
      throw e;
    }
  }
}







