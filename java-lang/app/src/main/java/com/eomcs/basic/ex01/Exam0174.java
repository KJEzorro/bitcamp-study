// Object 클래스 - clone() : deep copy
package com.eomcs.basic.ex01;

public class Exam0174 {

  static class Engine implements Cloneable {
    int cc;
    int valve;

    public Engine(int cc, int valve) {
      this.cc = cc;
      this.valve = valve;
    }

    @Override
    public String toString() {
      return "Engine [cc=" + cc + ", valve=" + valve + "]";
    }

    @Override
    public Engine clone() throws CloneNotSupportedException {
      return (Engine) super.clone();
    }
  }

  static class Car implements Cloneable {
    String maker;
    String name;
    Engine engine;

    public Car(String maker, String name, Engine engine) {
      this.maker = maker;
      this.name = name;
      this.engine = engine;
    }

    @Override
    public String toString() {
      return "Car [maker=" + maker + ", name=" + name + ", engine=" + engine + "]";
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
      // deep copy
      // => 포함하고 있는 하위 객체에 대한 복제를 수행하려면 다음과 같이 
      //    개발자가 직접 하위 객체를 복제하는 코드를 작성해야 한다.
      // 
      Car copy = (Car) super.clone(); // 주 객체가 먼저 와야 에러가 안나는듯?
      copy.engine = this.engine.clone();  // engine 객체도 복제해줘야 한다.
      return copy;
    }
  }

  public static void main(String[] args) throws Exception {
    Engine engine = new Engine(3000, 16);
    Car car = new Car("비트자동차", "비트비트", engine);

    // 자동차 복제 
    // => Car의 clone()에서 Engine 객체도 복제할 것이다.
    Car car2 = car.clone();

    System.out.println(car == car2);
    System.out.println(car);
    System.out.println(car2);
    System.out.println(car.engine == car2.engine); // false

    // car의 엔진과 car2의 엔진이 다른 엔진인지 확인해보자!
    car.engine.cc = 2000;
    System.out.println(car2.engine.cc);

    // 그 객체의 인스턴스 변수가 가리키고 있는(포함하고 있는) 객체까지 복제하는 것을
    // "deep copy(깊은 복제)"라 부른다.
    // 이전 예제와 달리 engine 객체도 복제된다.
    // deep copy는 개발자가 직접 clone() 메서드 안에 
    // deep copy를 수행하는 코드를 작성해야 한다.


  }
}







