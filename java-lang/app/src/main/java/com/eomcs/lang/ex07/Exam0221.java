package com.eomcs.lang.ex07;

// # 메서드 : 개념 및 기본 문법 II
//
public class Exam0221 {

  static void hello(String name, int age) {
    System.out.printf("%d살 %s님 반갑습니다.\n", age, name);
  }

  static void hello(String name, int age, String hobby, String ads) {
    System.out.printf("안녕하세요 제 이름은 %s입니다. 나이는 %d, 취미는 %s, 사는곳은 %s입니다.\n",name, age, hobby, ads);
  }

  public static void main(String[] args) {

    hello("김주은", 31);
    // 파라미터의 타입, 개수, 순서가 일치해야 한다.

    //    hello("윤봉길"); // 컴파일 오류!
    //    hello(20, "윤봉길"); // 컴파일 오류!
    //    String r = hello("안중근", 30); // 컴파일 오류!
    //    void r = hello("안중근", 30); // 컴파일 오류!
  }
}
