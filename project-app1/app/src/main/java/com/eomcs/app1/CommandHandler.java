package com.eomcs.app1;

public class CommandHandler {

  void doHelp() {
    System.out.println("add    [값1] [값2]    더하기 계산을 수행한다.");
    System.out.println("minus  [값1] [값2]    빼기 계산을 수행한다.");
    System.out.println("divide [값1] [값2]    나누기 계산을 수행한다.");
    System.out.println("help                 도움말을 실행한다.");
  }

  void doAdd(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("add 명령어 입력 형식이 옳바르지 않습니다.");
      System.out.println("형식: add 값1 값2");
      System.out.println("예) add 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%s %d + %d = %d\n", command.name, v1, v2, (v1 + v2));
    }
  }

  void doMinus(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("minus 명령어 입력 형식이 옳지 않습니다.");
      System.out.println("형식: minus 값1 값2");
      System.out.println("예) minus 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%s %d - %d = %d\n", command.name, v1, v2, (v1 - v2));
    }
  }

  void doDivide(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("divide 명령어 입력 형식이 옳지 않습니다.");
      System.out.println("형식: divide 값1 값2");
      System.out.println("예) divide 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%s %d / %d = %d\n", command.name, v1, v2, (v1 / v2));
    }
  }
}















