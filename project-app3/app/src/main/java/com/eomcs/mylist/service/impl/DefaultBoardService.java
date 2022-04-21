package com.eomcs.mylist.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;


@Service
public class DefaultBoardService implements BoardService {

  BoardDao boardDao;

  public DefaultBoardService(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Transactional
  @Override
  public int add(Board board) {
    return boardDao.insert(board);
  }

  @Override
  public List<Board> list(int pageSize, int pageNo) {
    return boardDao.findAll(pageSize, ((pageNo - 1) * pageSize));
  }

  @Transactional
  @Override
  public Board get(int no) {
    Board board = boardDao.findByNo(no);
    if (board != null) {
      boardDao.increaseViewCount(no);
    }
    return board;
  }

  @Transactional
  @Override
  public int update(Board board) {
    return boardDao.update(board);
  }

  @Transactional
  @Override
  public int delete(Board board) {
    return boardDao.delete(board);
  }

  @Override
  public int size() {
    return boardDao.countAll();
  }
}







