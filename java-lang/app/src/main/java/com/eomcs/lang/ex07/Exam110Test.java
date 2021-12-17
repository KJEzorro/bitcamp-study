package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam110Test {

  static void printSpaces(int len) {
    int spaceCnt = 1;
    while (spaceCnt <= len) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static void printStars(int len) {
    int starCnt = 1;
    while (starCnt <= len) {
      System.out.print("*");
      starCnt++;
    }
  }

  static int getSpaceLength(int totalStar, int displayStar) {
    return (totalStar - displayStar) / 2;
  }

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();


    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(getSpaceLength(len, starLen));
      printStars(starLen);
      System.out.println();
    }



    //    int starLen = 1;
    //    while (starLen <= len) {
    //      // 별 앞에 공백 출력
    //      printSpaces((len - starLen) / 2);
    //
    //      // 별 출력
    //      printStars(starLen);
    //
    //      // 출력 줄 바꾸기
    //      System.out.println();
    //      starLen += 2;
    //    }
  }
}