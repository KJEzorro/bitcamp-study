package com.eomcs.app1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[계산기 서버]");

    // 1) 클라이언트 App의 연결을 준비한다.
    ServerSocket serverSocket = new ServerSocket(8888);

    // 2) 클라이언트의 연결 요청을 승인한다.
    //    - 리턴 값은 클라이언트와 연결된 정보
    System.out.println("클라이언트의 연결을 기다림.");
    Socket socket = serverSocket.accept(); // 클라이언트가 연결될 때까지 리턴하지 않는다.
    System.out.println("클라이언트와 연결됨");

    // 클라이언트와 데이터를 주고 받을 입출력 도구를 준비한다.
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());

    // 클라이언트와 주고 받는 순서가 맞아야 한다.
    String request = in.nextLine();
    System.out.println("이름: " + request);

    out.println(request + "님 반갑습니다.");

    // 클라이언트와의 연결을 끊음
    socket.close();
    System.out.println("클라이언트 연결 종료");

    // 서버쪽 연결 도구 종료!
    serverSocket.close();
    System.out.println("서버 종료");


  }

}
