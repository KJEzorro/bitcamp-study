package com.eomcs.io;


// 기존 코드를 자신의 코드인양 사용하겠다고 선언한다.
public class FileReader2 extends java.io.FileReader{

  // super 클래스의 생성자는 바로 사용할 수 없다.
  // 서브 클래스의 생성자를 통해 사용해야 한다.
  public FileReader2(String filename) throws Exception {

    // 다음과 같이 수퍼 클래스의 생성자를 호출해야 한다.
    super(filename);
  }

}
