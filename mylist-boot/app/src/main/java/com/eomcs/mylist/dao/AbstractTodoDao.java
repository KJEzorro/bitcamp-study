package com.eomcs.mylist.dao;

import java.util.ArrayList;
import com.eomcs.mylist.domain.Todo;

// 서브 클래스의 공통 분모를 추출하여 수퍼 클래스를 정의할 경우,
// - 보통 이런 수퍼 클래스는 직접 사용하려고 만든 클래스가 아니다.
// - 단지 서브 클래스에게 공통 분모를 물려주려고 만든 클래스이다.
// - 이런 경우 "추상 클래스"로 선언한다.
// - 또한 추상 클래스 만이 추상 메서드를 가질 수 있기 때문에
//   추상 메서드가 있는 클래스는 반드시 추상 클래스로 선언해야 한다.
// 
public abstract class AbstractTodoDao implements TodoDao {  

  // 서브 클래스에서 접근해야 할 필드라면,
  // 접근 범위를 protected로 설정한다.
  protected ArrayList<Todo> todoList = new ArrayList<>();

  // 1) 데이터를 저장하는 save() 메서드가 반드시 있어야 한다.
  //    - insert(), update(), delete(), increaseViewCount() 메서드에서 save()를 사용한다.
  //    - 그래서 수퍼 클래스에 save() 메서드를 둬야 한다.
  // 2) 그러나 save()에서 데이터를 저장하는 방법은 서브 클래스마다 다르다.
  //    - 수퍼 클래스에서 save() 메서드를 구현해봐야 의미가 없다.
  //    - 왜? 어차피 서브클래스에서 재정의 할 테니까!
  //    - 이런 경우 해당 메서드를 "추상메서드"로 선언한다.
  // 3) 서브 클래스에서 오버라이딩 할 수 있도록 접근 가능해야 한다.
  //    - 그래야 서브 클래스가 다른 패키지에 있을 수 있다.
  //    - 이런 경우 메서드의 접근 범위를 protected 로 한다.
  protected abstract void save() throws Exception;

  @Override
  public int countAll() {
    return todoList.size();
  }

  @Override
  public Object[] findAll() {
    return todoList.toArray();
  } 

  @Override
  public void insert(Todo todo) throws Exception {
    todoList.add(todo);
    save();
  }

  @Override
  public Todo findByNo(int no) {
    if (no < 0 || no >= todoList.size()) {
      return null;
    }
    return todoList.get(no);
  }

  @Override
  public int update(int no, Todo todo) throws Exception {
    if (no < 0 || no >= todoList.size()) {
      return 0;
    }
    todoList.set(no, todo);
    save();
    return 1;
  }

  @Override
  public int updateDone(int no, boolean done) throws Exception {
    if (no < 0 || no >= todoList.size()) {
      return 0;
    }
    todoList.get(no).setDone(done);
    save();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= todoList.size()) {
      return 0;
    }
    todoList.remove(no);
    this.save();
    return 1;
  }
}











