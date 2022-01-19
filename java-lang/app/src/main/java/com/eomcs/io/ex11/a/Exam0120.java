// 인스턴스 입출력 - DataInputStream으로 인스턴스 읽기
package com.eomcs.io.ex11.a;

import java.io.DataInputStream; // Data Processing Stream Class = Decorator
import java.io.FileInputStream; // Data Sink Stream Class = Concrete Component

public class Exam0120 {

  public static void main(String[] args) throws Exception {

    FileInputStream fileIn = new FileInputStream("temp/member.data");
    DataInputStream in = new DataInputStream(fileIn);

    Member member = new Member();

    // 반드시 저장한 순서대로 읽어야 한다. 그러지 않으면 에러
    member.name = in.readUTF();
    member.age = in.readInt();
    member.gender = in.readBoolean();

    in.close();

    System.out.println(member);
  }
}


