package com.eomcs.oop.ex05.x5;

public class CarTest3 {
  public static void main(String[] args) {

    Sedan sedan = new Sedan();

    ElectricEngine electricOption = new ElectricEngine(sedan);
    electricOption.chargeBattery(100);

    Trailer trailer = new Trailer(electricOption);

    trailer.start();
    trailer.run();
    trailer.stop();

    System.out.println("-----------------------------------------------");

    Truck truck = new Truck();
    ElectricEngine electricOption2 = new ElectricEngine(truck);
    electricOption2.chargeBattery(100);


    truck.start();
    truck.run();
    truck.stop();

  }
}
