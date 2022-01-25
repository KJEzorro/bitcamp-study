package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

public abstract class AbstractBookDao implements BookDao {


  protected ArrayList bookList = new ArrayList();


  protected abstract void save() throws Exception;

  @Override
  public int countAll() {
    return bookList.size();
  }

  @Override
  public Object[] findAll() {
    return bookList.toArray();
  }

  @Override
  public void insert(Book book) throws Exception {
    bookList.add(book);
    save();
  }

  @Override
  public Book findByNo(int no) {
    if (no < 0 || no >= bookList.size()) {
      return null;
    }
    return (Book) bookList.get(no);
  }

  @Override
  public int update(int no, Book book) throws Exception {
    if (no < 0 || no >= bookList.size()) {
      return 0;
    }
    bookList.set(no, book);
    save();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= bookList.size()) {
      return 0;
    }
    bookList.remove(no);
    save();
    return 1;
  }


}
