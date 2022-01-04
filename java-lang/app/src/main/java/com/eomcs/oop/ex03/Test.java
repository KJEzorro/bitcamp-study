package com.eomcs.oop.ex03;

public class Test {

  static class Test135 {
    int a;
    int b;
    boolean c;

    Test135 () {}

    Test135 (int a) {
      this.a = a;
    }

    Test135 (int a, int b) {
      this.a = a;
      this.b = b;
    }

    Test135 (int a, int b, boolean c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    Test135 (int a, boolean c) {
      this.a = a;
      this.c = c;
    }

    Test135 (boolean c) {
      this.c = c;
    }
  }


  public static void main(String[] args) {

    Test135 test = new Test135(3, false);
    Test135 test2 = new Test135(3, 5, true);

    System.out.printf("%s%s%n",test.a, test.c);
    System.out.printf("%s%s%s%n",test2.a,test2.b, test2.c);
    System.out.println(test.c);


  }

}
