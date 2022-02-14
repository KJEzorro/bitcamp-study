package com.eomcs.oop.ex11.overview.step1;

import java.util.Arrays;

public class MyList {

  Object[] arr = new Object[10];
  int size;

  public void add(Object obj) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1)); // 오른쪽으로 1비트 이동한것은 50% 정도 더 큰 배열 증가
    }
    arr[size++] = obj;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException(); 
    }
    return arr[index];
  }

  public int size() {
    return size;
  }

  public Object remove(int index) {

    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }

    Object old = arr[index];
    for (int i = index; i < (size - 1); i++) {
      arr[i] = arr[i + 1];
    }
    --size;
    return old;
  }


}






