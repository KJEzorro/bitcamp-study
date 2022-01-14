package com.eomcs.oop.ex05.x6;

public class Suv extends Car {
  boolean enabled4wd;



  @Override
  public void run() {
    if (enabled4wd) {
      System.out.println("SUV 4WD run...");
    } else {
      System.out.println("SUV run...");
    }
  }



  public void active4wd(boolean enabled4wd) {
    this.enabled4wd = enabled4wd;
  }




}
