package com.eomcs.mylist;

import javax.sql.DataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  // DB 커넥션풀 준비
  public static DataSource datasource;

  static {
    try {
      datasource = new DriverManagerDataSource(
          "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");

    } catch (Exception e) {
      System.out.println("DB 연결 중 오류 발생");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
  //@Bean
  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
    return args -> {

      System.out.println("빈 컨테이너가 생성한 객체(빈 컨테이너에 들어 있는 객체):");

      String[] beanNames = beanContainer.getBeanDefinitionNames();
      for (int i = 0; i < beanNames.length; i++) {
        Object bean = beanContainer.getBean(beanNames[i]);
        System.out.printf("---->%03d: %s%n", i + 1, bean.getClass().getName());
      }
    };

  }

  @RequestMapping("/hello")
  String hello() {
    return "Hello World!";
  }

}
