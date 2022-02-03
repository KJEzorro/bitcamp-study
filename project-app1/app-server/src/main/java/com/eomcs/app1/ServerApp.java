package com.eomcs.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServerApp {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ServerApp.class, args);

  }
  @RequestMapping("/help")
  public String help() {
    StringBuilder strBuilder = new StringBuilder();
    strBuilder.append("<!DOCTYPE html>\n");
    strBuilder.append("<html>\n<head>\n<meta charset='UTF-8'>\n<title>웹계산기</title>\n</head>\n");
    strBuilder.append("<body>\n");
    strBuilder.append("<h1>웹 계산기 도움말</h1>\n");
    strBuilder.append("사용법:<br> \n");
    strBuilder.append("URL 형식 => http://서버주소:포트번호/calc?op=연산자&a=값1&b=값2<br>\n");
    strBuilder.append("예) http://localhost:8080/calc?op=-&a=100&b=200<br>\n");
    strBuilder.append("</body>\n</html>\n");
    return strBuilder.toString();

  }

}
