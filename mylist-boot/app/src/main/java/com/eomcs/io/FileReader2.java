package com.eomcs.io;

import java.io.FileReader;

// 기존 코드를 자신의 코드인양 사용하겠다고 선언한다.
public class FileReader2 {

  FileReader in;


  public FileReader2(String filename) throws Exception {
    in = new FileReader(filename);
  }

  public String readLine() throws Exception {
    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {
      if (c == '\n') { 
        return buf.toString();
      } else if (c == '\r') {

      }else { 
        buf.append((char) c);
      }
    }
    return buf.toString();

  }

  public void close() throws Exception{
    in.close();
  }


}
