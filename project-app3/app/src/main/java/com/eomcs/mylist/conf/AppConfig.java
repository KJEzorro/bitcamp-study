package com.eomcs.mylist.conf;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

// Spring 프레임워크의 설정 정보를 담은 클래스


// 1) Spring IoC 컨테이너에게 객체를 생성하기 위해 패키지를 알려준다. 
// => Spring Ioc 컨테이너는 패키지를 뒤져서 @Component, @Controller, @RestController, @Service 등이
//    붙은 클래스를 찾아내어 객체를 생성하고 보관한다.
@ComponentScan("com.eomcs.mylist") 

// 2) DB관련 설정을 할 때 DBMS 정보를 담은 properties 파일을 로딩한다.
@PropertySource("classpath:com/eomcs/mylist/conf/jdbc.properties")

// 3) DAO 인터페이스 구현체를 자동 생성하도록 명령한다.

@MapperScan("com.eomcs.mylist.dao")
public class AppConfig {

  @Bean // Spring IoC 컨테이너에게 다음 메서드를 실행한 후 리턴된 객체를 보관하라는 명령이다.
  public DataSource dataSource(
      @Value("${jdbc.driver}") String jdbcDriver,
      @Value("${jdbc.url}") String jdbcUrl,
      @Value("${jdbc.username}") String jdbcUsername,
      @Value("${jdbc.password}") String jdbcPassword) {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(jdbcDriver);
    ds.setUrl(jdbcUrl);
    ds.setUsername(jdbcUsername);
    ds.setPassword(jdbcPassword);
    return ds;
  }

  @Bean // Spring IoC 컨테이너에게 다음 메서드를 실행한 후 리턴된 객체를 보관하라는 명령이다.
  public PlatformTransactionManager transactionManager(
      DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, // DB 커넥션풀
      ApplicationContext appCtx // Spring IoC 컨테이너
      ) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.eomcs.mylist.domain");
    sqlSessionFactoryBean.setMapperLocations(
        appCtx.getResources("classpath:com/eomcs/mylist/dao/*Dao.xml"));
    return sqlSessionFactoryBean.getObject();
  }




}
