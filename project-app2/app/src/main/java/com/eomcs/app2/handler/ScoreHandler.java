package com.eomcs.app2.handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

public class ScoreHandler {

  ArrayList<Score> scores = new ArrayList<>();

  public ScoreHandler() {
    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));) {
      String line;
      while ((line = in.readLine()) != null) {
        scores.add(Score.fromCSV(line));
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생");
    }
  }

  private void save() {
    try (PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));) {
      for (Score score : scores) {
        out.println(score.toCSV());
      }
    } catch(Exception e) {
      System.out.println("데이터 저장 중 오류 발생");
    }
  }

  public void create() {
    Score score = new Score();
    score.setName(Prompt.promptString("이름? "));
    score.setKor(Prompt.promptInt("국어? "));
    score.setEng(Prompt.promptInt("영어? "));
    score.setMath(Prompt.promptInt("수학? "));

    scores.add(score);
    save();
  }

  public void list() {
    int count = 0;
    for (Score score : scores) {
      System.out.printf("%d: %s, %d, %.1f\n",
          count++,
          score.getName(),
          score.getSum(),
          score.getAverage());
    }

  }

  public void detail() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Score score = scores.get(no);
    System.out.printf("이름: %s\n", score.getName());
    System.out.printf("국어: %d\n", score.getKor());
    System.out.printf("영어: %d\n", score.getEng());
    System.out.printf("수학: %d\n", score.getMath());
    System.out.printf("합계: %d\n", score.getSum());
    System.out.printf("평균: %.1f\n", score.getAverage());
  }

  public void update() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Score old = scores.get(no);

    Score score = new Score();
    score.setName(Prompt.promptString("이름(%s)?", old.getName()));
    score.setKor(Prompt.promptInt("국어(%d)?", old.getKor()));
    score.setEng(Prompt.promptInt("영어(%d)?", old.getEng()));
    score.setMath(Prompt.promptInt("수학(%d)?", old.getMath()));

    scores.set(no, score);
    save();
  }

  public void delete() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    scores.remove(no);
    save();

  }

}
