package com.eomcs.oop.ex05.x6;

public class Sedan extends Car {
  boolean auto;
  boolean openedSunroof;



  @Override
  public void run() {
    System.out.println("Sedan run...");
  }

  public void openSunroof() {
    System.out.println("Sedan openSunroof...");
    this.openedSunroof = true;
  }

  public void closeSunroof() {
    System.out.println("Sedan closeSunroof...");
    this.openedSunroof = false;
  }
}
