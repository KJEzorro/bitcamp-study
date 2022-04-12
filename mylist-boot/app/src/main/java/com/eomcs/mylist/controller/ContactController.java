package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactService;

@RestController 
public class ContactController {

  @Autowired
  ContactService contactService; // 클래스 대신 인터페이스를 지정한다.

  @RequestMapping("/contact/list")
  public Object list() {
    return new ResultMap().setStatus(SUCCESS).setData(contactService.list());
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact, String[] tel) throws Exception {

    // 요청 파라미터 분석 및 가공
    ArrayList<ContactTel> telList = new ArrayList<>();
    for (int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split("_");
      if (value[1].length() == 0) {
        continue;
      }
      ContactTel contactTel = new ContactTel(Integer.parseInt(value[0]), value[1]);
      telList.add(contactTel);
    }
    contact.setTels(telList);

    contactService.add(contact);

    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/contact/get")
  public Object get(int no) {
    Contact contact = contactService.get(no);
    if (contact == null) {
      return new ResultMap().setStatus(FAIL).setData("해당 번호의 연락처가 없습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(contact);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact, String[] tel) throws Exception {
    // 요청 파라미터 분석 및 가공
    ArrayList<ContactTel> telList = new ArrayList<>();
    for (int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split("_");
      if (value[1].length() == 0) {
        continue;
      }
      // 연락처 변경의 경우 이미 연락처 번호를 알기 때문에 
      // 전화번호를 객체에 담을 때 연락처 번호도 함께 저장한다. 
      ContactTel contactTel = new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]);
      telList.add(contactTel);
    }
    contact.setTels(telList);

    // 서비스 객체 실행
    int count = contactService.update(contact);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("연락처 번호가 유효하지 않거나 연락처 등록자가 아닙니다.");
    }
  }

  @RequestMapping("/contact/delete")
  public Object delete(int no) throws Exception {
    int count = contactService.delete(no);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("연락처 번호가 유효하지 않거나 연락처 등록자가 아닙니다.");
    }
  }

}




