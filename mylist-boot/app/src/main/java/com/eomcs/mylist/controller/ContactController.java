package com.eomcs.mylist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;

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
  ContactDao contactDao;

  public ContactController() {
    System.out.println("ContactController() 호출됨!");
  }

  @RequestMapping("/contact/list")
  public Object list() {
    List<Contact> contacts = contactDao.findAll();
    for (Contact contact : contacts) {
      contact.setTels(contactDao.findTelByContactNo(contact.getNo()));
    }
    return contacts;
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact, String[] tel) {
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

  @RequestMapping("/contact/get")
  public Object get(int no) {
    Contact contact = contactDao.findByNo(no);
    if (contact == null) {
      return "";
    }
    contact.setTels(contactDao.findTelByContactNo(no));
    return contact;
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact, String[] tel) throws Exception {
    int count = contactDao.update(contact);
    if (count > 0) {
      contactDao.deleteTelByContactNo(contact.getNo());
      for (int i = 0; i < tel.length; i++) {
        String[] value = tel[i].split("_"); 
        if (value[1].length() == 0) {
          continue;
        } 
        contactDao.insertTel(new ContactTel(contact.getNo(),Integer.parseInt(value[0]), value[1]));
      }
    }
    return count;
  }

  @RequestMapping("/contact/delete")
  public Object delete(int no) throws Exception {
    contactDao.deleteTelByContactNo(no);
    return contactDao.delete(no);
  }

}




