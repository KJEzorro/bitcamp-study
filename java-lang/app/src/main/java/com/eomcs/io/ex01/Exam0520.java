// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기 II
package com.eomcs.io.ex01;

import java.io.File;
import java.sql.Date;

public class Exam0520 {

  public static void main(String[] args) throws Exception {

    File dir = new File(".");

    // 파일이나 디렉토리 정보를 File 객체로 받기
    // => File은 디렉토리와 파일을 통칭하는 용어다.
    //
    File[] files = dir.listFiles(); // listFiles()메서드는 list()와는 다르게 반환타입이 String타입이 아닌 '''File 타입'''이다

    for (File file : files) {
      System.out.printf("%s   %s %12d %s\n",
          file.isDirectory() ? "d" : "-",
              new Date(file.lastModified()),
              file.length(),
              file.getName());
    }

  }

}


