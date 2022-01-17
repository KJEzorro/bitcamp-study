// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0730x {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir, "");
  }

  static void printClasses(File dir, String packageName) throws Exception {

    class JavaClassFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if ((pathname.isFile() && pathname.getName().endsWith(".class")) ||
            pathname.isDirectory()) {
          return true;
        }
        return false;
      }
    }


    File[] files = dir.listFiles(new JavaClassFilter());
    for (File file : files) {
      if (file.isFile()) {
        System.out.println(packageName + "." + file.getName().replace(".class", ""));
      } else {
        String subPackageName;
        if (packageName.length() == 0) {
          subPackageName = file.getName();
        } else {
          subPackageName = packageName + "." + file.getName();
        }
        printClasses(file, subPackageName);
      }
    }


  }


}


