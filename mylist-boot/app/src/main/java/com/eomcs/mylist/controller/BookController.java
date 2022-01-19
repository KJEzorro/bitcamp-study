package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!");
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.ser2")));

      //    while (true) { 
      //      try {
      //        Book book = (Book) in.readObject();
      //        bookList.add(book);
      //
      //      } catch (Exception e) {
      //        break;
      //      }
      //    }

      bookList = (ArrayList) in.readObject();
      in.close();
    } catch (Exception e) {
      System.out.println("독서록 데이터를 로딩하는 중 오류 발생");
    }
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
    //  FileInputStream in = new FileInputStream("books.data");
    //  BufferedInputStream in2 = new BufferedInputStream(in);
    //  DataInputStream in3 = new DataInputStream(in2);


    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.ser2"))); 

    //    Object[] arr = bookList.toArray();
    //    for (Object obj : arr) {
    //      out.writeObject(obj);
    //    }

    out.writeObject(bookList);
    out.close();
    return bookList.size();
  }
}




