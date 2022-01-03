package com.eomcs.oop.ex01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test3 {


  public static void main(String[] args) {


    LocalDateTime now = LocalDateTime.now();
    String formatedNow = now.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));
  }




}

