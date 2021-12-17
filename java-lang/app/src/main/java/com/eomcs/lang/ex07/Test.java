package com.eomcs.lang.ex07;

public class Test {


  static void h1 (String a, int b) {
    System.out.printf("%s하하하 %d후후후", a, b);
  }

  static void h2(String name, String pos, int num) {
    System.out.printf("이 선수의 이름은 %s이고 등번호 %d 포지션은%s 입니다.", name, num, pos);
  }

  static int h3() {
    return 10;
  }

  static String h4(int kor, int eng, int math) {
    String val = String.format("국어: %d점, 영어: %d점, 수학: %d점", kor, eng, math);
    return val;
  }

  static void h5(String... str) {
    for (int i = 0; i < str.length; i++) {
      System.out.printf("str: %s%n", str[i]);
    }
  }

  int a = 10;
  int b = 15;

  static void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    System.out.printf("swap(): a=%d, b=%d\n", a, b);
  }





  public static void main(String[] args) {
    Test test = new Test();
    swap(test.a, test.b);
    System.out.printf("swap(): a=%d, b=%d\n", test.a, test.b);

  }

}
