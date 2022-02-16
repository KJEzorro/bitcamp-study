package com.eomcs.app2.vo;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;

  private void compute() {
    sum = kor + eng + math;
    average = sum / 3f;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getKor() {
    return kor;
  }
  public void setKor(int kor) {
    this.kor = kor;
    compute();

  }
  public int getEng() {
    return eng;
  }
  public void setEng(int eng) {
    this.eng = eng;
    compute();
  }
  public int getMath() {
    return math;
  }
  public void setMath(int math) {
    this.math = math;
    compute();
  }
  public int getSum() {
    return sum;
  }
  public float getAverage() {
    return average;
  }

  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", average=" + average + "]";
  }






}
