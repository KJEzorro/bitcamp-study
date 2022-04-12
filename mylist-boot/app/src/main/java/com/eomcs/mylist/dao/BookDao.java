package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Book;

@Mapper // => Mybatis는 다음 인터페이스의 구현체를 자동으로 생성한다.
public interface BookDao {

  int countAll();

  List<Book> findAll();

  int insert(Book book);

  Book findByNo(int no);

  int update(Book book);

  int delete(int no);
}











