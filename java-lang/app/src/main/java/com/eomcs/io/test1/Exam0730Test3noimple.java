package com.eomcs.io.test1;

import java.io.File;

public class Exam0730Test3noimple {
  public static void main(String[] args) throws Exception {
    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);


  }

  static void printClasses(File dir) {
    File[] files = dir.listFiles();
    for (File file : files) {
      if (file.isFile() && file.getName().endsWith(".class")) {
        System.out.println(file.getName());
      } else if (file.isDirectory()){
        printClasses(file);
      }
    }
  }

}
