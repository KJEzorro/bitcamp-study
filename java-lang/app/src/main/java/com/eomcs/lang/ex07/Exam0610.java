package com.eomcs.lang.ex07;

// # JVM 아규먼트
// ***************** 전 예제 방식보다 이방식을 많이쓴다. 이름을 주면 순서대로 하지 않아도된다.*********************
public class Exam0610 {

  public static void main(String[] 변수명은상관없다) {
    // JVM 아규먼트?
    // - JVM에게 전달하는 값
    // - 형식
    // $java -cp ./bin/main -D이름=값 -D이름=값 -D이름=값 com.eomcs.basic.ex07.Exam0610
    //

    // JVM 아규먼트의 값 꺼내기
    // => System.getProperty("이름");
    // => 꺼낸 값은 무조건 '문자열'이다
    String value1 = System.getProperty("a");
    String value2 = System.getProperty("b");
    String value3 = System.getProperty("c");

    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);

    //    $java -cp ./bin/main -Db=200 -Da=100 -Dc=300 com.eomcs.basic.ex07.Exam0610
    //  => a=100 b=200 c=300
  }
}


