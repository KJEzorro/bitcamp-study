package com.eomcs.app1;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[계산기 서버]");

    // 클라이언트 App의 연결을 준비한다.
    ServerSocket serverSocket = new ServerSocket(8888);

    while(true) {
      System.out.println("클라이언트의 연결을 기다림.");
      Socket socket = serverSocket.accept(); // 클라이언트가 연결될 때까지 리턴하지 않는다.
      System.out.println("클라이언트와 연결됨");

      // 클라이언트의 요청을 처리할 작업자를 만든다.
      Worker worker = new Worker(socket);
      worker.start(); // 작업자에게 일을 시킨 후 즉시 리턴한다.
      System.out.println("작업자에게 클라이언트 요청을 맡겼음.");

    }

    // 서버쪽 연결 도구 종료!
    //    serverSocket.close();
    //    System.out.println("서버 종료");


  }

}
