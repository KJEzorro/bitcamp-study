package com.eomcs.io.test1;

import java.io.File;
import java.io.FileFilter;

public class Exam0730Test2implements {
  public static void main(String[] args) throws Exception {
    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);


  }

  static void printClasses(File dir) throws Exception {

    class JavaClassFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if (pathname.isFile() && pathname.getName().endsWith(".class") ||
            pathname.isDirectory()) {
          return true;
        }
        return false;
      }
    }

    File[] files = dir.listFiles(new JavaClassFilter());
    for (File file : files) {
      if (file.isDirectory()) {
        printClasses(file);
      } else {
        System.out.println(file.getName());
      }
    }

  }

}
