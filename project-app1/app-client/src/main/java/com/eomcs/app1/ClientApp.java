package com.eomcs.app1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[계산기 클라이언트]");

    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.println("요청(형식: 서버주소/연산자/값1/값2)? ");
      System.out.print("=> ");
      String input = keyScan.nextLine();

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("종료");
        break;
      }

      int slashPos = input.indexOf("/"); // 예) +/100/200, */3/7, -/100/73, //4/16
      String serverAddress = input.substring(0, slashPos);
      String queryString = input.substring(slashPos + 1);

      // 서버 애플리케이션과 네트워크 연결을 수행한다.
      Socket socket = new Socket(serverAddress, 8888); // 서버와 연결될 때까지 객체를 생성하지 않는다.
      System.out.println("서버와 연결되었음!");

      // 데이터를 주고 받기 위한 입출력 스트림을 준비한다.
      PrintStream out = new PrintStream(socket.getOutputStream());
      Scanner in = new Scanner(socket.getInputStream());

      // 만약 연산자가 / 일 경우 %2f문자로 교체한다.
      if (queryString.startsWith("/")) {
        queryString = queryString.replaceFirst("/", "%2f"); // 서버에 보내는 데이터 형식에 어긋나지 않도록 인코딩 한다.
      }

      // 서버에 데이터를 보낸다.
      out.println(queryString);

      // 서버가 응답한 데이터를 읽는다.
      String response = in.nextLine(); // 서버가 한 줄의 문자열을 보낼 때까지 리턴하지 않는다.
      System.out.println("==>" + response);

      // 입출력 도구를 다 사용했으면 자원을 해제한다.
      out.close();
      in.close();

      // 서버 애플리케이션과 연결된 것을 끊는다.
      socket.close();

      System.out.println("서버 연결 종료");
    }

    keyScan.close();

  }

}
