package com.eomcs.app1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

  @RequestMapping("/calc")
  public String calc(String op, double a, double b) {
    String response = null;

    switch (op) {
      case "+": 
        response = String.format("%.2f", (a + b));
        break;

      case "-":
        response = String.format("%.2f", (a - b));
        break;

      case "*":
        response = String.format("%.2f", (a * b));
        break;

      case "/":
        response = String.format("%.2f", (a / b));
        break;

      default:
        response = "연산 불가";
    }
    return response;


  }


}
