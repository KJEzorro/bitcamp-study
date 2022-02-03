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
        response = String.format("JE: %.1f + %.1f = %.2f", a, b, (a + b));
        break;

      case "-":
        response = String.format("JE: %.1f - %.1f = %.2f", a, b, (a - b));
        break;

      case "*":
        response = String.format("JE: %.1f * %.1f = %.2f", a, b, (a * b));
        break;

      case "/":
        response = String.format("JE: %.1f / %.1f = %.2f", a, b, (a / b));
        break;

      default:
        response = "JE: 지원하지 않는 연산자입니다.";
    }
    return response;


  }


}
