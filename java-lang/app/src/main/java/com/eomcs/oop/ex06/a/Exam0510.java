// 다형성 - 다형적 변수와 instanceof 연산자
package com.eomcs.oop.ex06.a;

public class Exam0510 {

  public static void main(String[] args) {
    Vehicle v = new Sedan();

    // instanceof 연산자?
    // => 레퍼런스에 들어있는 주소가 특정 클래스의 인스턴스인지 검사한다.
    // => 또는 그 상위/하위 클래스의 인스턴스인지 검사한다.
    //
    System.out.println(v instanceof Sedan);     // true
    System.out.println(v instanceof Car);       // true Car 의 자손 맞다.
    System.out.println(v instanceof Vehicle);   // true Vegicle 의 자손 맞다.
    System.out.println(v instanceof Object);    // true Object 의 자손 맞다.

    System.out.println(v instanceof Truck);     // false
    System.out.println(v instanceof Bike);      // false
  }

}




