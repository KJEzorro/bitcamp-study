package com.eomcs.oop.ex02;

import com.eomcs.oop.ex02.util.Calculator2;
import com.eomcs.oop.ex02.util.Calculator3;

public class ExamTest2 {

  public static void main(String[] args) {

    Calculator2 cal = new Calculator2();
    Calculator3 cal3 = new Calculator3();

    cal.plus(3);
    cal.plus(2);
    cal.minus(1);
    cal.multiple(7);
    cal.divide(3);
    cal.remainder(2);
    System.out.printf("result = %d\n", cal.getResult());


    System.out.println("plus: " + cal3.plus(23.1, 21.9));
    System.out.println("minus: " + cal3.minus(41.1, 3.9));
    System.out.println("multiple: " + cal3.multiple(3.2, 9.3));
    System.out.println("divide: " + cal3.divide(3f, 3f));
    System.out.println("remainder: " + cal3.remainder(3, 3));



  }


}

