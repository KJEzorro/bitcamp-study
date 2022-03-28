package com.eomcs.mylist.controller;

import java.io.File;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.mylist.domain.Book;
import com.eomcs.mylist.service.BookService;

@RestController 
public class BookController {

  @Autowired
  BookService bookService;

  @RequestMapping("/book/list")
  public Object list() {
    return bookService.list(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book, MultipartFile file) throws Exception {
    try {
      book.setPhoto(saveFile(file));
      return bookService.add(book);

    } catch (Exception e) {
      e.printStackTrace();
      return "error!";
    }
  }


  @RequestMapping("/book/get")
  public Object get(int no) {
    Book book = bookService.get(no);
    return book != null ? book : "";
  }

  @RequestMapping("/book/update")
  public Object update(Book book, MultipartFile file) throws Exception{
    try {
      book.setPhoto(saveFile(file));
      return bookService.update(book);

    } catch (Exception e) {
      e.printStackTrace();
      return "error!";
    }
  }

  @RequestMapping("/book/delete")
  public Object delete(int no) throws Exception {
    return bookService.delete(no);
  }


  private String saveFile(MultipartFile file) throws Exception {
    if (file != null && file.getSize() > 0) { 
      // 파일을 저장할 때 사용할 파일명을 준비한다.
      String filename = UUID.randomUUID().toString();

      // 파일명의 확장자를 알아낸다.
      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }

      // 파일을 지정된 폴더에 저장한다.
      File photoFile = new File("c:/upload/book/" + filename);
      file.transferTo(photoFile);

      return filename;

    } else {
      return null;
    }
  }
}



