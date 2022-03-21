package com.eomcs.mylist.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactServiceTransaction2;

//1) 생성자에서 FileReader 객체를 준비한다.
//2) 파일에서 문자를 읽어 출력한다.
//3) 파일을 더이상 읽을 수 없으면 반복문을 종료한다.
//4) 파일에서 읽은 문자를 버퍼에 담았다가 줄바꿈 코드를 만나면 출력한다. 
//5) 한 줄 출력한 다음에 버퍼를 비운다.
//6) 한 줄의 CSV 데이터를 읽어 분석한 후 Contact 객체에 담아서 목록에 추가한다.
//7) CSV 데이터로 Contact 객체를 초기화시키는 일을 Contact 객체의 생성자로 옮긴다.
//8) Contact 클래스의 valueOf() 스태틱 메서드를 사용하여 CSV 데이터로 객체를 생성한다.
//9) while 문 정리!
//
@RestController
public class ContactController {

  @Autowired
  ContactServiceTransaction2 contactService;

  public ContactController() {
    System.out.println("ContactController() 호출됨!");
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactService.list();
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact, String[] tel) {

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
    // 서비스 객체 실행
    return contactService.add(contact);

    /*
    // 1) 트랜잭션으로 묶어서 실행할 작업을 정의
    // => 스프링 프레임워크에서 정한 규칙에 따라 정의해야 한다.
    class ContactAddTransaction implements TransactionCallback {
      @Override
      public Object doInTransaction(TransactionStatus status) {
        // 트랜잭션으로 묶어서 할 작업을 기술한다.
        contactDao.insert(contact);
        for (int i = 0; i < tel.length; i++) {
          String[] value = tel[i].split("_"); 
          if (value[1].length() == 0) {
            continue;
          }
          contactDao.insertTel(new ContactTel(contact.getNo(),Integer.parseInt(value[0]), value[1]));
        }
        return 1;
      }
    }
    // 2) 트랜잭션 작업을 수행한다.
    return transactionTemplate.execute(new ContactAddTransaction());
     */
  }

  @RequestMapping("/contact/get")
  public Object get(int no) {
    Contact contact = contactService.get(no);
    if (contact == null) {
      return ""; // 컨트롤러는 서비스 객체의 리턴 값에 따라 응답 데이터를 적절히 가공하여 리턴한다.
    }
    return contact;
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact, String[] tel) {
    // 요청 파라미터 분석 및 가공
    ArrayList<ContactTel> telList = new ArrayList<>(); 
    for (int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split("_"); 
      if (value[1].length() == 0) {
        continue;
      }
      // 연락처 변경의 경우 이미 연락처 번호를 알기 때문에
      // 전화번호를 객체에 담을 때 연락처 번호도 함게 저장한다. 
      ContactTel contactTel = new ContactTel(contact.getNo(),Integer.parseInt(value[0]), value[1]);
      telList.add(contactTel);
    }
    contact.setTels(telList);
    // 서비스 객체 실행
    return contactService.update(contact);
  }

  @RequestMapping("/contact/delete")
  public Object delete(int no) {
    return contactService.delete(no);
  }

}




