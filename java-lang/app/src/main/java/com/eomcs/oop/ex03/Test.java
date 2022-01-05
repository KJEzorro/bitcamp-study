package com.eomcs.oop.ex03;


class Test {
  class TTT {
    int a = 10;
  }




  public static void main(String[] args) {
    Test a = new Test();
    TTT t = a.new TTT();

    System.out.println(t.a);
  }

}
