package com.eomcs.mylist;

public class ArrayList2 {

  static Todo[] list = new Todo[5];
  static int size = 0;


  //기능:
  // - 배열에서 지정한 항목을 삭제한다.
  //
  static Todo remove(int index) {
    Todo old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];
    }
    size--;
    return old;
  }

  // 기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  //
  static Todo[] grow() {
    Todo[] arr = new Todo[newLength()];
    copy(list, arr);
    return arr;
  }


  //기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  //
  static int newLength() {
    return list.length + (list.length >> 1);
  }


  //기능: 
  // - 배열을 복사한다.
  // 
  static void copy(Todo[] source, Todo[] target) {
    // 개발자가 잘못 사용할 것을 대비해서 다음 코드를 추가한다.
    // 즉 target 배열이 source 배열 보다 작을 경우 target 배열 크기만큼만 복사한다.
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

  // 기능: 
  // - 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한다.
  static Todo[] toArray() {
    Todo[] arr = new Todo[size];
    for (int i = 0; i < size; i++) { 
      arr[i] = list[i];
    }
    return arr; 
  }


  // 기능:
  // - 배열에 항목을 추가한다.
  // - 배열이 꽉찼으면 배열의 크기를 늘린다.
  // - 
  static void add(Todo contact) {
    if (size == list.length) {
      list = grow();
    }
    list[size++] = contact;

  }

  // 기능:
  // - 배열의 특정 위치의 값을 변경한다.
  // - return 값:
  //    -변경하기 전에 저장되어 있던 값이다.
  //
  static Todo set(int index, Todo contact) {
    if(index < 0 || index >= size) {  // 값이 저장된 위치가 무효한 인덱스라면
      return null;
    }
    Todo old = list[index];
    list[index] = contact;
    return old;
  }





}
