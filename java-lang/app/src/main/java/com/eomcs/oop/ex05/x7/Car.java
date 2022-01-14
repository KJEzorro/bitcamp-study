package com.eomcs.oop.ex05.x7;

public abstract class Car { 
  int cc;
  int valve;

  public void start() {
    System.out.println("Car start...");
  }

  public void stop() {
    System.out.println("Car stop...");
  }

  public abstract void run();



}
