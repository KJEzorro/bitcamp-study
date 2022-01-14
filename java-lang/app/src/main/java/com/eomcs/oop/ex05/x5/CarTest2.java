package com.eomcs.oop.ex05.x5;

public class CarTest2 {
  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    Trailer trailer = new Trailer(sedan);
    CampingTrailer ct = new CampingTrailer();
    ct.aircond = "삼성에어컨";
    ct.tv = "lgTV";
    trailer.setTrailer(ct);
    trailer.start();
    trailer.run();
    trailer.stop();



    System.out.println("-----------------------------------------------");

    Truck truck = new Truck();
    Trailer trailer2 = new Trailer(truck);
    trailer2.start();
    trailer2.run();
    trailer2.stop();

  }
}
