package com.eomcs.mylist.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactService;

//@Service
public class TransactionManagerContactService implements ContactService {

  @Autowired
  ContactDao contactDao;
  @Autowired
  PlatformTransactionManager transactionManager;



  @Override
  public int add(Contact contact) {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("t1"); // 트랜잭션 이름 설정. 같은 이름의 트랜잭션에 묶인 경우 한 단위로 취급된다.
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED); // 트랜잭션 정책 설정
    // => 이 메서드를 호출하는 쪽에서 트랜잭션이 있으면 이 메서드의 작업들도 그 트랜잭션에 소속된다.
    // => 이 메서드를 호출하는 쪽에서 트랜잭션이 없다면 이 메서드에서 새 트랜잭션을 만들어 작업을 수행한다.

    TransactionStatus status = transactionManager.getTransaction(def);

    try {
      contactDao.insert(contact);
      for (ContactTel tel : contact.getTels()) {
        tel.setContactNo(contact.getNo()); // 전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
        contactDao.insertTel(tel);
      }
      transactionManager.commit(status);
      return 1;

    } catch (Exception e) {
      transactionManager.rollback(status);
      throw e;
    }
  }

  @Override
  public List<Contact> list() {
    List<Contact> contacts = contactDao.findAll();
    for (Contact contact : contacts) {
      contact.setTels(contactDao.findTelByContactNo(contact.getNo()));
    }
    return contacts;
  }

  @Override
  public Contact get(int no) {
    Contact contact = contactDao.findByNo(no);
    if (contact != null) {
      contact.setTels(contactDao.findTelByContactNo(no));
    }
    return contact;
  }

  @Override
  public int update(Contact contact) {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("t1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus status = transactionManager.getTransaction(def);

    try {
      int count = contactDao.update(contact);
      if (count > 0) {
        contactDao.deleteTelByContactNo(contact.getNo()); // 전화번호 변경 전에 기존 전화번호를 모두 삭제한다.
        for (ContactTel tel : contact.getTels()) {
          contactDao.insertTel(tel); // 전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
        }
      }
      transactionManager.commit(status);
      return count;
    } catch (Exception e) {
      transactionManager.rollback(status);
      throw e;
    }
  }

  @Override
  public int delete(int no) {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("t1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = transactionManager.getTransaction(def);
    try {
      contactDao.deleteTelByContactNo(no);
      int count = contactDao.delete(no);

      transactionManager.commit(status);
      return count;

    } catch (Exception e) {
      transactionManager.rollback(status);
      throw e;
    }
  }
















}
