package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Contact;

public interface ContactDao {  

  // 인터페이스는 객체 메서드 호출 규칙을 정의하는 것이기 때문에 
  // 메서드를 작성할 때 메서드 몸체(method body)를 작성하지 말아야 한다.
  // 메서드 바디가 없는 메서드를 "추상 메서드(abstract method)"라 부른다.

  int countAll();

  Object[] findAll();

  void insert(Contact contact) throws Exception;

  Contact findByEmail(String email);

  int update(Contact contact) throws Exception;

  int delete(String email) throws Exception;


}











