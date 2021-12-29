package com.eomcs.mylist;

public class ArrayList {
  // 인스턴스 필드(변수)
  // => 인스턴스 필드는 new 명령을 통해 생성한다.
  Object[] list = new Object[5];
  int size = 0;


  // 기능: 
  // - 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한다.
  static Object[] toArray(ArrayList that) {
    Object[] arr = new Object[that.size];
    for (int i = 0; i < that.size; i++) { 
      arr[i] = that.list[i];
    }
    return arr; 
  }


  //기능:
  // - 배열에서 지정한 항목을 삭제한다.
  //
  static Object remove(ArrayList that, int index) {
    if(index < 0 || index >= that.size) {  // 값이 저장된 위치가 무효한 인덱스라면
      return null;
    }
    Object old = that.list[index];
    for (int i = index + 1; i < that.size; i++) {
      that.list[i - 1] = that.list[i];
    }
    that.size--;
    return old;
  }


  // 기능:
  // - 배열의 특정 위치의 값을 변경한다.
  // - return 값:
  //    -변경하기 전에 저장되어 있던 값이다.
  //
  static Object set(ArrayList that, int index, Object obj) {
    if(index < 0 || index >= that.size) {  // 값이 저장된 위치가 무효한 인덱스라면
      return null;
    }
    Object old = that.list[index];
    that.list[index] = obj;
    return old;
  }



  // 기능:
  // - 배열에 항목을 추가한다.
  // - 배열이 꽉찼으면 배열의 크기를 늘린다.
  // - 
  static void add(ArrayList that, Object obj) {
    if (that.size == that.list.length) {
      that.list = grow(that);
    }
    that.list[that.size++] = obj;

  }


  // 기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  //
  static Object[] grow(ArrayList that) {
    Object[] arr = new Object[newLength(that)];
    copy(that.list, arr);
    return arr;
  }

  //기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  //
  static int newLength(ArrayList that) {
    return that.list.length + (that.list.length >> 1);
  }


  //기능: 
  // - 배열을 복사한다.
  // 
  static void copy(Object[] source, Object[] target) {
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



}
