package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Book;

public interface BookDao {



  public int countAll();

  public Object[] findAll();

  public void insert(Book book) throws Exception;

  public Book findByNo(int no);

  public int update(int no, Book book) throws Exception;

  public int delete(int no) throws Exception;
}
