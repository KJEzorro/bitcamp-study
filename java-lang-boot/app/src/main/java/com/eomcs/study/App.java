package com.eomcs.study;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
//@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
  @RequestMapping("/hello")
  String hello() {
    return "Hello, java-lang-boot!";
  }

}