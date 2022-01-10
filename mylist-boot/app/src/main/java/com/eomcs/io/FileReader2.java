package com.eomcs.io;

// 기존 코드를 자신의 코드인양 사용하겠다고 선언한다.
public class FileReader2 extends java.io.FileReader{

  // super 클래스의 생성자는 바로 사용할 수 없다.
  // 서브 클래스의 생성자를 통해 사용해야 한다.
  public FileReader2(String filename) throws Exception {

    // 다음과 같이 수퍼 클래스의 생성자를 호출해야 한다.
    super(filename);

  }

  public String readLine() throws Exception {

    StringBuilder buf =  new StringBuilder();
    int c;

    while ((c = this.read()) != -1) { // 파일에서 한 문자를 읽는다. 더이상 읽을 문자가 없으면 반복문을 종료한다.
      if (c == '\n') {  // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 버퍼에 저장한 문자를 리턴한다.
        return buf.toString();
      } else if(c == '\r') {
        // 무시! CR(Carrage Return; \r) 코드는 버퍼에 담지 말고 버린다.
      }
      else {
        buf.append((char) c); // 문자를 읽을 때마다 버퍼에 임시 보관한다.
      }
    }
    return buf.toString();
  }

}
