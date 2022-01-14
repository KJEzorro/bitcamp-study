package com.eomcs.oop.ex05.x7;

public class Sedan extends Car {
  boolean auto;
  boolean openedSunroof;



  @Override
  public void run() {
    System.out.println("Sedan run...");
  }

  public void openSunroof() {
    this.openedSunroof = true;
    System.out.println("Sedan openSunroof...");
  }

  public void closeSunroof() {
    this.openedSunroof = false;
    System.out.println("Sedan closeSunroof...");
  }

}
