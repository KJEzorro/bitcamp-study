package com.eomcs.oop.ex11.overview.step1;

public class MyStack extends MyList {

  public void push(Object obj) {
    this.add(obj);
  }

  public Object pop() {
    return remove(--size);
  }

}
