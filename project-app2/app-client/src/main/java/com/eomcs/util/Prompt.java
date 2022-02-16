package com.eomcs.util;

import java.util.Scanner;

public class Prompt {

  static Scanner keyScan = new Scanner(System.in);

  public static String promptString(String titleFormat, Object... args) {
    System.out.print(String.format(titleFormat, args));
    return keyScan.nextLine();
  }

  public static int promptInt(String titleFormat, Object... args) {
    return Integer.parseInt(promptString(titleFormat, args));
  }

}
