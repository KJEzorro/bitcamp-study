package com.eomcs.oop.ex05.x6;

public abstract class Car {
  int cc;
  int valve;

  public void start() {
    System.out.println("start...");
  }

  public void stop() {
    System.out.println("stop...");
  }

  public abstract void run();


}
