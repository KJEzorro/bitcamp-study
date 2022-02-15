// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0510x {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {

    Calculator obj = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return x + y;
      }
    };


    class CalculatorImpl implements Calculator {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    }

    // 2) 람다 문법 활용
    Calculator obj2 = (x, y) -> x * y;

    Calculator c1 = MyCalculator::plus;
    Calculator c2 = MyCalculator::minus;
    Calculator c3 = MyCalculator::multiple;
    Calculator c4 = MyCalculator::divide;

    System.out.println(c1.compute(200, 17)); // compute() ==> plus()
    System.out.println(c2.compute(200, 17)); // compute() ==> minus()
    System.out.println(c3.compute(200, 17)); // compute() ==> multiple()
    System.out.println(c4.compute(200, 17)); // compute() ==> divide()

    Calculator calc = new CalculatorImpl();
    System.out.println(calc.compute(100, 200));



    // 결국 익명 클래스던 람다 문법이던 메서드 레퍼런스던 단축 문법일 뿐인 것을 알아두자.

    // 익명 클래스
    Calculator calc2 = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    };
    System.out.println(calc2.compute(100, 200));

    // 람다 문법
    Calculator calc3 = (x, y) -> MyCalculator.plus(x, y);
    System.out.println(calc3.compute(100, 200));

    // 메서드 레퍼런스
    // Calculator을 구현한 구현체가 calc4에 저장되는 것이다.
    // 절대로 MyCalculator의 plus()가 호출되는 것이 아니다.
    // MyCalculator::plus; -> 구현체 단축 문법이라 생각하면 된다.
    Calculator calc4 = MyCalculator::plus; 
    System.out.println(calc4.compute(100, 200));

  }
}


