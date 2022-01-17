// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0510 {

  public static void main(String[] args) throws Exception {

    // 현재 폴더의 정보를 알아낸다.
    File dir = new File(".");

    // 현재 폴더에 있는 파일이나 하위 디렉토리 이름을 알아내기
    String[] names = dir.list(); // 타입을 보면 알겠지만 list() 메서드는 String 반환 타입이 '''String 타입'''이다.

    for (String name : names) {
      System.out.println(name);
    }
  }
}


