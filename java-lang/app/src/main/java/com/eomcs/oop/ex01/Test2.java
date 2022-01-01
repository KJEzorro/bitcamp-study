package com.eomcs.oop.ex01;

public class Test2 {

  static class KKK {
    String name;
    String adr;
    String gender;
    int age;

  }

  static class BBB {
    String a;
    String b;
    String c;
    String d;
  }



  public static void main(String[] args) {

    KKK[] k = new KKK[3];

    for (int i = 0; i < k.length; i++) {
      k[i] = new KKK();
    }
    k[1].name = "하하하";
    k[1].adr = "서울";
    k[1].age = 30;
    k[1].gender = "남자";

    //    for (int i = 0; i < k.length; i++) {
    //      System.out.printf("%s, %s, %d, %s%n", k[i].name, k[i].adr, k[i].age, k[i].gender);
    //    }

    BBB b = new BBB();
    b.a = "a";
    b.b = "b";
    b.c = "c";
    b.d = "d";
    System.out.printf("%s   %s   %s   %s%n",b.a, b.b, b.c, b.d);

    BBB b2 = b;
    b2.c = "ddd";

    System.out.printf("%s   %s   %s   %s%n",b.a, b.b, b.c, b.d);







  }




}

