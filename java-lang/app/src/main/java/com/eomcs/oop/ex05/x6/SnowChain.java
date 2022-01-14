package com.eomcs.oop.ex05.x6;

public class SnowChain extends Option {

  public SnowChain(Car car) {
    super(car);
  }

  @Override
  public void run() {
    System.out.println("SnowChain run...");
    car.run();
  }

}
