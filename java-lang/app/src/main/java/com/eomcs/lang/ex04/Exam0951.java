package com.eomcs.lang.ex04;

//# 형변환 - 명시적 형변환이 불가능한 경우, 특별한 메서드를 사용하면 가능하다. 
// 
public class Exam0951 {
  public static void main(String[] args) {

    byte b = Byte.valueOf("100");
    short s = Short.valueOf("32767");
    int i1 = Integer.valueOf("2122223333");
    int i2 = Integer.parseInt("2122223333");
    long l = Long.valueOf("9221111222233334444");
    float f1 = Float.valueOf("3.14f");  // 문자열 ==> float
    float f2 = Float.parseFloat("3.14f");  // 문자열 ==> float
    double d1 = Double.valueOf("9876.54321");
    double d2 = Double.parseDouble("9876.54321");
    boolean bool1 = Boolean.valueOf("1"); // 문자열 ==> boolean
    boolean bool2 = Boolean.parseBoolean("TRUE"); // 문자열 ==> boolean
    char c = "가".charAt(0);




    System.out.println(b);
    System.out.println(s);
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(l);
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(bool1);
    System.out.println(bool2);
    System.out.println(c);
  }
}
