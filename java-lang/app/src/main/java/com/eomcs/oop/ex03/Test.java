package com.eomcs.oop.ex03;


public class Test {

  class Patient {
    String name;
    String id;
    String gender;
    String bloodType;
    int age;

    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    public String getGender() {
      return gender;
    }
    public void setGender(String gender) {
      this.gender = gender;
    }
    public String getBloodType() {
      return bloodType;
    }
    public void setBloodType(String bloodType) {
      this.bloodType = bloodType;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      this.age = age;
    }
    @Override
    public String toString() {
      return "Patient [name=" + name + ", id=" + id + ", gender=" + gender + ", bloodType="
          + bloodType + ", age=" + age + "]";
    }

  }

  public static void main(String[] args) {
    Test t = new Test();
    Patient patient1 = t.new Patient();
    patient1.setName("홍길동");
    patient1.setId("911111-1234456");
    patient1.setGender("남");
    patient1.setBloodType("RH+ A");
    patient1.setAge(30);

    System.out.println(patient1.toString());

  }

}
