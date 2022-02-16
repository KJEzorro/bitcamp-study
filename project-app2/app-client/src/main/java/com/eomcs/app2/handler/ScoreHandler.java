package com.eomcs.app2.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

public class ScoreHandler {

  ObjectInputStream in;
  ObjectOutputStream out;

  public ScoreHandler(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }


  public void create() throws Exception {
    Score score = new Score();
    score.setName(Prompt.promptString("이름? "));
    score.setKor(Prompt.promptInt("국어? "));
    score.setEng(Prompt.promptInt("영어? "));
    score.setMath(Prompt.promptInt("수학? "));

    out.writeUTF("insert");
    out.writeObject(score);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      int count = in.readInt();
      if (count == 1) {
        System.out.println("입력 했습니다.");
      } else {
        System.out.println("입력하지 못했습니다.");
      }
    } else {
      System.out.println(in.readUTF());
    }
  }

  public void list() throws Exception {

    out.writeUTF("selectList");
    out.flush();


    String status = in.readUTF();
    if (status.equals("success")) {
      Score[] scores = (Score[]) in.readObject();
      int count = 0;
      for (Score score : scores) {
        System.out.printf("%d: %s, %d, %.1f\n",
            count++,
            score.getName(),
            score.getSum(),
            score.getAverage());
      }
    } else {
      System.out.println(in.readUTF());
    }
  }

  public void detail() throws Exception {
    int no = Prompt.promptInt("번호? ");

    out.writeUTF("selectOne");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      Score score = (Score) in.readObject();
      System.out.printf("이름: %s\n", score.getName());
      System.out.printf("국어: %d\n", score.getKor());
      System.out.printf("영어: %d\n", score.getEng());
      System.out.printf("수학: %d\n", score.getMath());
      System.out.printf("합계: %d\n", score.getSum());
      System.out.printf("평균: %.1f\n", score.getAverage());
    } else {
      System.out.println(in.readUTF());
    }

  }

  public void update() throws Exception {
    int no = Prompt.promptInt("번호? ");

    out.writeUTF("selectOne");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      Score old = (Score) in.readObject();

      Score score = new Score();
      score.setName(Prompt.promptString("이름(%s)?", old.getName()));
      score.setKor(Prompt.promptInt("국어(%d)?", old.getKor()));
      score.setEng(Prompt.promptInt("영어(%d)?", old.getEng()));
      score.setMath(Prompt.promptInt("수학(%d)?", old.getMath()));

      out.writeUTF("update");
      out.writeInt(no);
      out.writeObject(score);
      out.flush();

      status = in.readUTF();
      if (status.equals("success")) {
        int count = in.readInt();
        if (count == 1) {
          System.out.println("변경 했습니다.");
        } else {
          System.out.println("변경하지 못했습니다.");
        }
      } else {
        System.out.println(in.readUTF());
      }
    } else {
      System.out.println(in.readUTF());
    }
  }

  public void delete() throws Exception {
    int no = Prompt.promptInt("번호? ");

    out.writeUTF("delete");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      int count = in.readInt();
      if (count == 1) {
        System.out.println("삭제 했습니다.");
      } else {
        System.out.println("삭제하지 못했습니다.");
      }
    } else {
      System.out.println(in.readUTF());
    }
  }

}
