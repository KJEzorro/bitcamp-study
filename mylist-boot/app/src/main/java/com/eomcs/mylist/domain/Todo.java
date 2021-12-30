package com.eomcs.mylist.domain;

public class Todo {
  String title;
  boolean done;


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

  @Override
  public String toString() {
    return "Todo [title=" + title + ", done=" + done + "]";
  }





}
