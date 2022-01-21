import java.util.Scanner;

public class Test1 {

  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {

    while(true) {
      String input = prompt();

      if (input.equals("quit") || input.equals("exit")) {
        break;

      } else if (input.length() == 0) {
        continue;

      } else if (input.equals("help")) {
        doHelp();

      } else {
        String[] values = input.split(" ");

        if (values[0].equals("add")) {
          doAdd(values);

        } else if (values[0].equals("minus")) {
          doMinus(values);

        } else {
          System.out.println("지원하지 않는 연산자입니다.");
        }
      }
    }
    keyScan.close();




  }


  static void doHelp() {
    System.out.println("add   [값1] [값2]    더하기 계산을 수행한다.");
    System.out.println("minus [값1] [값2]    빼기 계산을 수행한다.");
    System.out.println("help                 도움말을 실행한다.");
  }

  static void doAdd(String[] values) {
    if (values.length != 3) {
      System.out.println("add 명령어 입력 형식이 옳바르지 않습니다.");
      System.out.println("형식: add 값1 값2");
      System.out.println("예) add 100 200");
    } else {
      int v1 = Integer.parseInt(values[1]);
      int v2 = Integer.parseInt(values[2]);
      System.out.printf("%s %d + %d = %d\n", values[0], v1, v2, (v1 + v2));
    }
  }

  static void doMinus(String[] values) {
    if (values.length != 3) {
      System.out.println("minus 명령어 입력 형식이 옳지 않습니다.");
      System.out.println("형식: minus 값1 값2");
      System.out.println("예) minus 100 200");
    } else {
      int v1 = Integer.parseInt(values[1]);
      int v2 = Integer.parseInt(values[2]);
      System.out.printf("%s %d - %d = %d\n", values[0], v1, v2, (v1 - v2));
    }
  }


  static String prompt() {
    System.out.print("> ");
    return keyScan.nextLine();
  }



}
