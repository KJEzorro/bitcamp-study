package com.eomcs.mylist.domain;

public class Todo {
  int no;
  String title;
  boolean done;

  @Override
  public String toString() {
    return "Todo [no=" + no + ", title=" + title + ", done=" + done + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public boolean isDone() {
    return done;
  }
  public void setDone(boolean done) {
    this.done = done;
  }



}
