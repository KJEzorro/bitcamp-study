package com.eomcs.oop.ex05.x3.app3;


// 캠핑카 만들기
//
// 2) app1에서 복제해 온 Engine 클래스에 기능 덧붙이기

public class CarTest3 {
  public static void main(String[] args) {
    // CampingTrailer 클래스를 만든다.
    // Engine 클래스에 트레일러를 설정하는 변수와 메서드를 추가한다.
    // - trailer, setTrailer() 추가
    // - run() 변경
    CampingTrailer trailer = new CampingTrailer();

    Engine car = new Engine();
    car.setTrailer(trailer);
    car.start();
    car.run();
    car.stop();

  }
}
