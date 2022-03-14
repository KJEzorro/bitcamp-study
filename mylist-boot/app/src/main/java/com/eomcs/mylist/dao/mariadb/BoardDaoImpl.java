package com.eomcs.mylist.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;
// @Repository
// - 클래스에 이 애너테이션을 붙여 표시해 두면, Spring Boot가 실행될 때 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.

@Repository   
public class BoardDaoImpl implements BoardDao {

  @Autowired
  SqlSessionFactory sqlSessionFactory; // => Mybatis: 제공하는 SQL 실행 도구를 만들어 주는 객체.

  public BoardDaoImpl() {
    System.out.println("BoardDao 객체 생성");
  }

  @Override
  public int countAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.selectOne("BoardDao.sql5");
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
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.insert("BoardDao.sql3", board);
    }
  }

  @Override
  public Board findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.selectOne("BoardDao.sql2", no);
    }
  }

  @Override
  public int update(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.selectOne("BoardDao.sql4", board);
    }
  }

  @Override
  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.delete("BoardDao.sql6", no);
    }
  }

  @Override
  public int increaseViewCount(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.update("BoardDao.sql7", no);
    }
  }  
}

