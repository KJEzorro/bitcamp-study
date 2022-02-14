package com.eomcs.algorithm.data_structure.linkedlist2.step2;


// 컬렉션의 값을 조회하는 일을 수행한다.
// 
@SuppressWarnings("rawtypes")
public class ListIterator implements Iterator {

  LinkedList list;
  int cursor;

  public ListIterator(LinkedList list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    return cursor < list.size();
  }

  @Override
  public Object next() {
    return list.get(cursor++);

  }


}
