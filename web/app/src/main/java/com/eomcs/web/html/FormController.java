package com.eomcs.web.html;

import java.io.File;
import java.util.HashMap;
import javax.servlet.ServletContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FormController {


  ServletContext sc; // 서버에 배포된 웹 애플리케이션의 정보를 다루는 객체

  @RequestMapping("/html/form/exam01")
  public Object exam01() {
    return "Hello!";
  }

  @RequestMapping("/html/form/exam02")
  public Object exam02(String name, int age) {
    HashMap<String,Object> map = new HashMap<>();
    map.put("name", name);
    map.put("age", age);

    return map;
  }

  @RequestMapping("/html/form/exam11")
  public Object exam11(String name, int age, MultipartFile photo) {
    System.out.println(name);
    System.out.println(age);
    System.out.println(photo.getOriginalFilename());

    try {
      File photoFile = new File("c:/upload/" + photo.getOriginalFilename());
      photo.transferTo(photoFile);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
    return "ok!";
  }

  @RequestMapping("/html/form/exam12")
  public Object exam12(String name, int age, MultipartFile[] photo) {
    System.out.println(name);
    System.out.println(age);

    for (MultipartFile Part : photo) {

      try {
        File photoFile = new File("c:/upload/" + Part.getOriginalFilename());
        Part.transferTo(photoFile);
      } catch (Exception e) {
        e.printStackTrace();
        return "error";
      }
    }
    return "ok!";
  }

  @RequestMapping("/html/form/exam21")
  public Object exam21(String name, int age) throws Exception {
    System.out.println(name);
    System.out.println(age);

    //    Thread.sleep(10000);

    return "ok!";
  }

  @RequestMapping("/html/form/exam31")
  public Object exam31(String name, int age, MultipartFile photo) {
    System.out.println(name);
    System.out.println(age);
    System.out.println(photo.getOriginalFilename());

    if (photo != null && photo.getSize() > 0) {
      System.out.println(photo.getOriginalFilename());

      try {
        File photoFile = new File("c:/upload/" + photo.getOriginalFilename());
        photo.transferTo(photoFile);
      } catch (Exception e) {
        e.printStackTrace();
        return "error";
      }
    }
    return "ok!";
  }


}
