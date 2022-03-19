package com.eomcs.mylist.domain;

public class ContactTel {
  int no;
  int contactNo;
  int telTypeNo;
  String tel;

  @Override
  public String toString() {
    return "ContactTel [no=" + no + ", contactNo=" + contactNo + ", telTypeNo=" + telTypeNo
        + ", tel=" + tel + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getContactNo() {
    return contactNo;
  }
  public void setContactNo(int contactNo) {
    this.contactNo = contactNo;
  }
  public int getTelTypeNo() {
    return telTypeNo;
  }
  public void setTelTypeNo(int telTypeNo) {
    this.telTypeNo = telTypeNo;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }


}
