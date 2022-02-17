package com.eomcs.app2.handler;

import com.eomcs.app2.net.ScoreTableProxy;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

public class ScoreHandler {

  ScoreTableProxy scoreTable;

  public ScoreHandler(ScoreTableProxy scoreTable) {
    this.scoreTable = scoreTable;
  }


  public void create() throws Exception {
    Score score = new Score();
    score.setName(Prompt.promptString("이름? "));
    score.setKor(Prompt.promptInt("국어? "));
    score.setEng(Prompt.promptInt("영어? "));
    score.setMath(Prompt.promptInt("수학? "));

    int count = scoreTable.insert(score);

    if (count == 1) {
      System.out.println("입력 했습니다.");
    } else {
      System.out.println("입력하지 못했습니다.");
    }
  } 

  public void list() throws Exception {

    Score[] scores = scoreTable.selectList();

    int count = 0;
    for (Score score : scores) {
      System.out.printf("%d: %s, %d, %.1f\n",
          count++,
          score.getName(),
          score.getSum(),
          score.getAverage());
    }
  }

  public void detail() throws Exception {
    int no = Prompt.promptInt("번호? ");

    Score score = scoreTable.selectOne(no);

    System.out.printf("이름: %s\n", score.getName());
    System.out.printf("국어: %d\n", score.getKor());
    System.out.printf("영어: %d\n", score.getEng());
    System.out.printf("수학: %d\n", score.getMath());
    System.out.printf("합계: %d\n", score.getSum());
    System.out.printf("평균: %.1f\n", score.getAverage());
  }

  public void update() throws Exception {
    int no = Prompt.promptInt("번호? ");

    Score old = scoreTable.selectOne(no);

    Score score = new Score();
    score.setName(Prompt.promptString("이름(%s)?", old.getName()));
    score.setKor(Prompt.promptInt("국어(%d)?", old.getKor()));
    score.setEng(Prompt.promptInt("영어(%d)?", old.getEng()));
    score.setMath(Prompt.promptInt("수학(%d)?", old.getMath()));

    int count = scoreTable.update(no, score);
    if (count == 1) {
      System.out.println("변경 했습니다.");
    } else {
      System.out.println("변경하지 못했습니다.");
    }
  }

  public void delete() throws Exception {
    int no = Prompt.promptInt("번호? ");

    int count = scoreTable.delete(no);
    if (count == 1) {
      System.out.println("삭제 했습니다.");
    } else {
      System.out.println("삭제하지 못했습니다.");
    }
  }
}
