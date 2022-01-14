package com.eomcs.oop.ex05.x6;

public class Truck extends Car {
  int weight;

  // 과거의 유산(legacy)를 위해서 기존 메서드를 호출한다.
  @Override
  public void run() {
    // 기존에 이미 있는 메서드를 호출한다.
    this.go();
  }

  @Override
  public void start() {
    this.launch();
  }

  @Override
  public void stop() {
    this.stopping();
  }

  public void launch() {
    System.out.println("Truck launch...");
  }

  public void stopping() {
    System.out.println("Truck stopping...");
  }

  public void go() {
    System.out.println("Truck go...");
  }

  public void dump() {
    System.out.println("Truck dump...");
  }

}
