package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.io.FileReader2;
import com.eomcs.io.FileWriter2;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!");
    FileReader2 in = new FileReader2("books.csv");

    String line;
    while ((line = in.readLine()).length() != 0) {
      bookList.add(Book.valueOf(line)); 
    }

    in.close();
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()) {
      return "";
    }
    return bookList.get(index);
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0 : 1;
  }

  @RequestMapping("/book/save")
  public Object save() throws Exception {
    FileWriter2 out = new FileWriter2("books.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.

    Object[] arr = bookList.toArray();
    for (Object obj : arr) {
      Book book = (Book) obj;
      out.println(book.toCsvString());
    }

    out.close();
    return arr.length;
  }
}




