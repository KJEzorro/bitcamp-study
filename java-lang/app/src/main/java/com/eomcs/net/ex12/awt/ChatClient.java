package com.eomcs.net.ex12.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {

  public ChatClient() {
    super("계산기");
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // 윈도우의 x 버튼을 눌렀을 때
        System.exit(0);
      }
    });
    this.setSize(400, 300);
    this.setVisible(true);
  }

  public static void main(String[] args) {

    new ChatClient();

  }
}
