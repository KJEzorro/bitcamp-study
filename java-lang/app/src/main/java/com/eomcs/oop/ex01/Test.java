package com.eomcs.oop.ex01;

public class Test {
  static class Contacts {
    String name;
    String phone;
    String adr;
    int age;
  }

  static Contacts createContact (String name, String phone, String adr, int age) {
    Contacts c = new Contacts();

    c.name = name;
    c.phone = phone;
    c.adr = adr;
    c.age = age;

    return c;
  }

  static void printContact (Contacts[] contacts) {
    for (int i = 0; i < contacts.length; i++) {
      System.out.printf(" name: %s%n phone: %s%n adr: %s%n age: %d%n", contacts[i].name, contacts[i].phone, contacts[i].adr, contacts[i].age);
      System.out.println();
    }

  }

  public static void main(String[] args) {
    Contacts[] con = new Contacts[5];


    con[0] = createContact("홍길동", "010-1293-5872", "서울", 30);
    con[1] = createContact("임꺽정", "010-5723-9272", "부산", 38);
    con[2] = createContact("장길산", "010-9261-2362", "울산", 34);
    con[3] = createContact("기러기", "010-2975-5141", "대전", 23);
    con[4] = createContact("호랑이", "010-2963-1131", "강원", 40);

    printContact(con);






  }
}
