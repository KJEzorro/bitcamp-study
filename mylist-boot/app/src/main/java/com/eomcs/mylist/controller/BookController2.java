package com.eomcs.mylist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book2;
import com.eomcs.util.ArrayList;

@RestController
public class BookController2 {
  ArrayList bookList2 = new ArrayList();

  public BookController2() {
    System.out.println("BookController() 호출됨");
  }

  @RequestMapping("/book2/list")
  public Object list() {
    return bookList2.toArray(); 
  }


  @RequestMapping("/book2/add")
  public Object add(Book2 book) {

    book.setListDate(nowTime());
    bookList2.add(book);
    return bookList2.size();
  }


  @RequestMapping("/book2/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList2.size()) {
      return "";
    }
    Book2 book = (Book2) bookList2.get(index);
    return book;
  }


  @RequestMapping("/book2/update")
  public Object update(int index, Book2 book) {
    if (index < 0 || index >= bookList2.size()) {
      return 0;
    }
    book.setListDate(nowTime());
    return bookList2.set(index, book) == null ? 0 : 1;
  }


  @RequestMapping("/book2/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList2.size()) {
      return 0;
    }
    return bookList2.remove(index) == null ? 0 : 1;
  }


  String nowTime() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));

  }
}
