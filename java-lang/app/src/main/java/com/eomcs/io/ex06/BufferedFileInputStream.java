package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.IOException;

public class BufferedFileInputStream extends FileInputStream {
  byte[] buf = new byte[8192];
  int size; // 배열에 저장되어 있는 바이트의 수
  int cursor; // 바이트 읽은 배열의 위치

  public BufferedFileInputStream(String filename) throws Exception {
    super(filename);
  }

  // 파일에서 버퍼로 왕창 읽어 온 횟수
  int readCount = 0;

  @Override
  public int read() throws IOException {
    if (cursor == size) { // 바이트 배열에 저장되어 있는 데이터를 모두 읽었다면,
      if ((size = super.read(buf)) == -1) { // 다시 파일에서 바이트 배열로 데이터를 왕창 읽어 온다.
        return -1;
      }
      readCount++;
      System.out.printf("==> 버퍼로 왕창 읽었음. - %d 번째\n", readCount);
      cursor = 0;
    }
    return buf[cursor++] & 0x000000ff; 
    // 1 byte의 값이 4 byte로 변환될 때 음수의 경우 앞의 3byte가 모두 ff가 되는 문제 발생
    // 그래서 & 연산자로 앞 3byte 제거 = ''& 0x000000ff'' 


    // 위의 리턴 문장은 컴파일 할 때 아래의 4 문장으로 바뀐다.
    //    int temp;
    //    temp = buf[cursor];
    //    cursor++;
    //    return temp & 0x000000ff;
  }

}


