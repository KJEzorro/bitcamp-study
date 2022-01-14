package com.eomcs.oop.ex05.x7;

public class Suv extends Car {
  boolean enabled4wd;

  @Override
  public void run() {
    if (enabled4wd) {
      System.out.println("Suv 4wd run...");
    } else {
      System.out.println("Suv run...");
    }
  }

  public void active4wd(boolean enable) {
    this.enabled4wd = enable;
  }

}
