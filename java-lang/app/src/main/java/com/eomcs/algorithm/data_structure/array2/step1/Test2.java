package com.eomcs.algorithm.data_structure.array2.step1;

import com.eomcs.algorithm.data_structure.array2.Score;

public class Test2 {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("임꺽정", 90, 100, 70));
    list.add(new Score("유관순", 80, 78, 87));
    list.add(new Score("안중근", 83, 91, 84));
    list.add(new Score("윤봉길", 93, 80, 78));

    // 불편2:
    // => 목록에 값을 저장할 때 원하지 않는 타입의 값이 들어가는 것을 막을 수 없다.
    list.add(new String("오호라"));

    for (int i = 0; i < list.size(); i++) {
      Score s = (Score) list.get(i);
      System.out.printf("%s: %d, %f\n", s.name, s.sum, s.aver);
    }
  }

}
