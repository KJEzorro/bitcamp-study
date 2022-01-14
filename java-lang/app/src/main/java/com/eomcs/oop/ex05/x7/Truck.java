package com.eomcs.oop.ex05.x7;

public class Truck extends Car {
  int weight;

  @Override
  public void start() {
    this.launch();
  }

  @Override
  public void run() {
    this.go();
  }

  @Override
  public void stop() {
    this.stopping();
  }

  public void launch() {
    System.out.println("Truck launch...");
  }

  public void go() {
    System.out.println("Truck go..."); 
  }

  public void stopping() {
    System.out.println("Truck stopping...");
  }

  public void dump() {
    System.out.println("Truck dump...");
  }
}
