package com.eomcs.mylist.web.listener;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mylist.controller.Component;
import com.eomcs.mylist.service.BoardService;
import com.eomcs.mylist.service.impl.DefaultBoardService;

// 역할:
// - 웹애플리케이션이 시작될 때 서비스 객체, DAO 객체, Mybatis 객체를 준비한다.
// 
@WebListener
public class ContextLoaderListener implements ServletContextListener {

  ServletContext sc;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 웹애플리케이션이 시작되면 이 메서드가 호출될 것이다.
    System.out.println("서비스 및 DAO, Mybatis 객체 준비!");

    try {
      // 1) Mybatis의 SqlSessionFactory 준비
      String resource = "com/eomcs/mylist/conf/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);

      // 2) 서비스 객체 생성
      BoardService boardService = new DefaultBoardService(sqlSessionFactory);
      //      MemberService memberService = new DefaultMemberService(sqlSessionFactory);

      // 3) @Component가 붙은 클래스를 찾아 객체를 생성하고,
      //    프론트 컨트롤러가 해당 객체를 사용할 수 있도록 ServletContext 보관소에 저장한다.
      //
      this.sc = sce.getServletContext();
      sc.setAttribute("boardService", boardService);

      createBeans("com.eomcs.mylist.controller");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void createBeans(String packageName) throws Exception {
    // packageName: 예) com.eomcs.mylist.controller
    String packagePath = packageName.replace(".", "/");

    // 웹애플리케이션이 배포된 폴더의 실제 경로를 알아낸다.
    String contextPath = sc.getRealPath("/");

    // 웹애플리케이션 배포 폴더에서 패키지가 있는 경로를 알아낸다.
    File dir = new File(contextPath + "WEB-INF/classes/" + packagePath);

    // 패키지 폴더를 뒤져서(browse) @Component가 붙은 클래스를 알아낸다.
    findComponent(dir, packageName);
  }

  private void findComponent(File dir, String packageName) throws Exception {
    File[] files = dir.listFiles(file -> {
      if (file.isDirectory()) return true;
      if (file.getName().endsWith(".class") && !file.getName().contains("$")) return true;
      return false;
    });

    for (File f : files) {
      if (f.isDirectory()) {
        findComponent(f, packageName + "." + f.getName());
      } else {
        // 패키지 이름을 포함한 클래스 이름을 알아낸다.
        String className = packageName + "." + f.getName().replace(".class", "");

        // 클래스 이름을 가지고 .class 파일을 찾아 로딩한다.
        Class<?> classInfo = Class.forName(className);

        // 클래스 정보에서 @Component 애노테이션을 추출한다.
        Component compAnno = classInfo.getAnnotation(Component.class);
        if (compAnno == null) { 
          continue; // @Component 애노테이션은 붙은 클래스가 아니라면 다음 항목을 반복한다.
        }

        // 클래스의 생성자를 알아낸다.
        Constructor<?> constructor = classInfo.getConstructors()[0];

        // 생성자의 파라미터를 알아낸다.
        Parameter[] params = constructor.getParameters();

        // 생성자를 호출할 때 넘겨줄 값을 담을 배열을 준비한다.
        Object[] args = new Object[params.length];

        // 생성자의 파라미터 타입에 해당되는 값을 찾아 배열에 담는다.
        for (int i = 0; i < params.length; i++) {
          args[i] = getObject(params[i].getType());
        }

        // 생성자를 호출하여 객첵를 생성한다.
        Object obj = constructor.newInstance(args);

        // 생성된 객체를 ServletContext 보관소에 담는다.
        // 이때 이름은 @Component 애노테이션의 value 값을 사용한다.
        sc.setAttribute(compAnno.value(), obj);
      }
    }
  }

  // ServletContext 보관소에서 타입에 해당하는 객체를 찾는다.
  private Object getObject(Class<?> type) {
    Enumeration<String> names = sc.getAttributeNames();
    while (names.hasMoreElements()) {
      Object obj = sc.getAttribute(names.nextElement());
      if (type.isInstance(obj)) {
        return obj;
      }
    }
    return null;
  }
}









