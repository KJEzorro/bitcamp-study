package com.eomcs.mylist;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
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

  // 이렇게 인스턴스 필드로 주거나, 아래의 createDataSource() 메서드의 파라미터로 줄 수도 있다.
  //  @Value("${spring.datasource.driver-class-name}")
  //  String driverClassName;
  //  @Value("${spring.datasource.url}")
  //  String Url;
  //  @Value("${spring.datasource.username}")
  //  String username;
  //  @Value("${spring.datasource.password}")
  //  String password;

  // Spring 프레임워크(IoC = Object pool(객체풀)) 에서 객체를 생성한 후 보관하도록 만드는 방법
  @Bean 
  // => 스프링 부트를 시작할 때 다음 메서드를 호출하게 만든다.
  // => 이 메서드가 리턴한 값은 스프링 부트의 객체풀에(Object pool) 보관한다.
  // 
  public DataSource DataSource(
      @Value("${spring.datasource.driver-class-name}") String driverClassName,
      @Value("${spring.datasource.url}") String Url,
      @Value("${spring.datasource.username}") String username,
      @Value("${spring.datasource.password}") String password) {
    try {
      DriverManagerDataSource connectionPool = new DriverManagerDataSource();
      connectionPool.setDriverClassName(driverClassName);
      connectionPool.setUrl(Url);
      connectionPool.setUsername(username);
      connectionPool.setPassword(password);
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
