package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BookDao;
import com.eomcs.mylist.domain.Book;

@RestController 
public class BookController {

  @Autowired
  BookDao bookDao;


  public BookController() {
    System.out.println("BookController() 호출됨!");
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookDao.findAll(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) throws Exception {
    bookDao.insert(book);
    return bookDao.countAll();
  }


  @RequestMapping("/book/get")
  public Object get(int index) throws Exception {
    Book book = bookDao.findByNo(index);
    return book != null ? book : "";
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) throws Exception {
    Book old = bookDao.findByNo(index);
    if (old == null) {
      return 0;
    }
    return bookDao.update(index, book);
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) throws Exception {
    Book old = bookDao.findByNo(index);
    if (old == null) {
      return 0;
    }
    return bookDao.delete(index);
  }
}




