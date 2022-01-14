package com.eomcs.oop.ex05.x7;

public class BlackBox extends Option {

  public BlackBox(Car car) {
    super(car);
  }

  @Override
  public void start() {
    super.start();
    System.out.println("blackBox on...");
  }

  @Override
  public void run() {
    car.run();
  }

  @Override
  public void stop() {
    super.stop();
    System.out.println("blackBox off...");
  }

}
