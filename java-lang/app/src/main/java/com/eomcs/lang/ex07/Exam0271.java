package com.eomcs.lang.ex07;

// # 메서드 : 가변 파라미터의 단점
//
public class Exam0271 {

  static void m2(int a, String... names) {} // OK!

  // 배열 파라미터는 여러 개 선언할 수 있다.
  static void x1(String[] names, String[] emails) {
    for (int i = 0; i < names.length; i++) {
      System.out.println(names[i]);
      System.out.println(emails[i]);
    }
  }

  // 배열 파리미터는 순서에 상관 없다.
  static void x2(String[] names, int a) {}

  public static void main(String[] args) {
    String[] arr1 = {"aaa","bbb","ccc"};
    String[] arr2 = {"aaa1","bbb2","ccc3"};
    String[] arr3 = {"aaa","bbb","ccc"};
    String[] arr4 = {"aaa","bbb","ccc"};

    x1(arr1, arr2);

    // 컴파일 확인하라!
  }
}

// 결론!
// - 메서드에 가변 파라미터는 한 개만 사용할 수 있다.
// - 가변 파라미터는 반드시 맨 뒤에 와야 한다.
// - 그 이유는 복잡한 사용을 막기 위해!


