package com.eomcs.app1;

import java.io.PrintStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Scanner;

public class Worker extends Thread {

  Socket socket;

  public Worker(Socket socket) {
    this.socket = socket;
  }
  @Override
  public void run() {
    try {
      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());

      // 1) http 요청 데이터 읽기
      String requestLine = in.nextLine();
      System.out.println(requestLine);


      //나머지 데이터는 버린다.
      while (true) {
        String str = in.nextLine();
        if (str.length() == 0) {
          break;
        }
      }
      // 예) requestLine = "GET /plus/100/200 HTTP/1.1"

      String requestUri = requestLine.split(" ")[1]; // 예) /+/100/200 HTTP/1.1" 
      String[] values = requestUri.split("/"); // 예) {"", "+", "100", "200"}

      if (values.length == 4) {
        String op = URLDecoder.decode(values[1], "UTF-8"); // "%2b" -> "+", "-", "*", "%2f" -> "/"
        int a = Integer.parseInt(values[2]); // 100
        int b = Integer.parseInt(values[3]); // 200
        System.out.printf("%s, %d, %d\n", op, a, b);

        String response = null;

        switch (op) {
          case "+": 
            response = String.format("주은: %d + %d = %d", a, b, (a + b));
            break;

          case "-":
            response = String.format("주은: %d - %d = %d", a, b, (a - b));
            break;

          case "*":
            response = String.format("주은: %d * %d = %d", a, b, (a * b));
            break;

          case "/":
            response = String.format("주은: %d / %d = %d", a, b, (a / b));
            break;

          default:
            response = "JE: 지원하지 않는 연산자입니다.";
        }
        writeResponse(out, response);

      } else {
        writeResponse(out, "요청 형식이 올바르지 않습니다.");
      } 
      socket.close();
      System.out.println("클라이언트 연결 종료!");

    }catch (Exception e) {
      e.printStackTrace();
    }

  }



  // 2) http 응답 데이터 보내기
  private void writeResponse(PrintStream out, String messageBody) throws Exception {

    out.println("HTTP/1.1 200 OK");
    out.println("Content-Type: text/plain; charset=utf-8");
    out.println();
    out.print(messageBody);
    out.flush();

  }

}










