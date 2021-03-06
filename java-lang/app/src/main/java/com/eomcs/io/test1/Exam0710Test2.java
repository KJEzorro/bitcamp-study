package com.eomcs.io.test1;

import java.io.File;

public class Exam0710Test2 {

  public static void main(String[] args) throws Exception {
    File dir = new File(".");


    printList(dir, 1);


  }

  static void printList(File dir, int level) {
    File[] files = dir.listFiles();
    for (File file : files) {
      printIndent(level);
      if (file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s/\n", file.getName());
        printList(file, level + 1);
      } else if (file.isFile()) {
        System.out.printf("%s\n", file.getName());

      }
    }

  }

  static void printIndent(int level) {
    for (int i = 0; i < level; i++) {
      System.out.print("  ");
    }
  }


}
