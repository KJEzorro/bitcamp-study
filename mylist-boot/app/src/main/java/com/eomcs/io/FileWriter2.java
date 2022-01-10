package com.eomcs.io;

// 상속 문법을 사용하여 기존의 FileWriter 클래스를 연결한다.
// 그런 후 마치 자신의 코드인 양 사용한다.
public class FileWriter2 extends java.io.FileWriter {

  // 이 클래스의 생성자를 통해 FileWriter 클래스의 생성자를 호출한다.
  public FileWriter2(String filename) throws Exception {
    super(filename);
  }

  // 한 줄 단위로 출력하는 기능을 추가한다.
  public void println(String str) throws Exception {
    this.write(str + "\n");
  }

}
