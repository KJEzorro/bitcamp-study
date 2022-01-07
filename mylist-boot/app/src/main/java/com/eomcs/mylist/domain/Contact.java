package com.eomcs.mylist.domain;

public class Contact {
  String name;
  String email;
  String tel;
  String company;

  public Contact() {
    System.out.println("Contact() 호출됨");
  }

  // => 적용 기술
  // => 인스턴스 메서드 : 특정 인스턴스를 사용한다면 인스턴스 메서드로 만들라!
  // => GRASP의 Information Expert 패턴
  //    데이터를 가공하는 기능은 그 데이터를 갖고 있는 클래스에 둬야 한다.
  public String toCsvString() {
    return String.format("%s, %s, %s, %s", 
        this.getName(), 
        this.getEmail(), 
        this.getTel(), 
        this.getCompany());
  }



  @Override
  public String toString() {
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", company=" + company
        + "]";
  }



  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public String getEmail() {
    return email;
  }



  public void setEmail(String email) {
    this.email = email;
  }



  public String getTel() {
    return tel;
  }



  public void setTel(String tel) {
    this.tel = tel;
  }



  public String getCompany() {
    return company;
  }



  public void setCompany(String company) {
    this.company = company;
  }


}
