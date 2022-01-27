package com.eomcs.app1;

import java.net.Socket;

public class ClientApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[계산기 클라이언트]");

    // 1) 서버 애플리케이션과 네트워크 연결을 수행한다.
    Socket socket = new Socket("127.0.0.1", 8888); // 서버와 연결될 때까지 객체를 생성하지 않는다.
    System.out.println("서버와 연결되었음!");

    // 서버 애플리케이션과 연결된 것을 끊는다.
    socket.close();
    System.out.println("서버 연결 종료");

  }

}
