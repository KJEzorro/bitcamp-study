package com.eomcs.mylist;

import javax.sql.DataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  // Spring 프레임워크(IoC = Object pool(객체풀)) 에서 객체를 생성한 후 보관하도록 만드는 방법
  @Bean // => 다음 메서드를 호출한 후 이 메서드가 리턴한 값을 스프링 부트에 보관하라고 지시하는 애노테이션
  public DataSource createDataSource() {
    System.out.println("createDataSource() 호출됨!!!!");
    try {
      DriverManagerDataSource connectionPool = new DriverManagerDataSource();
      connectionPool.setDriverClassName("org.mariadb.jdbc.Driver");
      connectionPool.setUrl("jdbc:mariadb://localhost:3306/studydb");
      connectionPool.setUsername("study");
      connectionPool.setPassword("1111");
      return connectionPool;

    } catch (Exception e) {
      throw new RuntimeException(e);
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
