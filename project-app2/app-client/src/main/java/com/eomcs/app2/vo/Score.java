package com.eomcs.app2.vo;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;

  public static Score fromCSV(String csv) {
    String[] values = csv.split(",");
    Score score = new Score();
    score.setName(values[0]);
    score.setKor(Integer.parseInt(values[1]));
    score.setEng(Integer.parseInt(values[2]));
    score.setMath(Integer.parseInt(values[3]));
    return score;
  }

  public String toCSV() {
    return String.format("%s,%d,%d,%d",
        this.getName(),
        this.getKor(),
        this.getEng(),
        this.getMath());
  }

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
