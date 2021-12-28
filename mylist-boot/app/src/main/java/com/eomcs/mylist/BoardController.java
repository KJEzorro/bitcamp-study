package com.eomcs.mylist;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class BoardController {


  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList3.toArray();
  }


  @RequestMapping("/board/add")
  public Object add(Board board) {
    ArrayList3.add(board);
    Date date = new Date();
    long timeInMilliSeconds = date.getTime();
    java.sql.Date today = new java.sql.Date(timeInMilliSeconds);

    // 방금 추가한 게시물이 배열의 맨마지막에 있기 때문에 
    // 배열의 맨마지막 것을 선택하여 날짜를 설정해준다
    ((Board) ArrayList3.toArray()[ArrayList3.size - 1]).setCreatedDate(today);

    return ArrayList3.size;
  }


  @RequestMapping("/board/get")
  public Object get(String title) {
    int index = indexOf(title);
    if (index == -1) {
      return "";
    }
    //    setViewCount를 통해 서버에 있는 게시물의 viewCount를 하나 올려준다.
    ((Board) ArrayList3.list[index]).setViewCount(((Board)
        // 서버에서  기존 viewCount를 가져와서 +1 해준다
        ArrayList3.list[index]).getViewCount() + 1);
    return ArrayList3.list[index];
  }



  @RequestMapping("/board/update")
  public Object update(Board board) {
    int index = indexOf(board.title);
    if (index < 0 || index >= ArrayList3.size) {
      return 0;
    }
    return ArrayList3.set(index, board) == null ? 0 : 1;
  }


  @RequestMapping("/board/delete")
  public Object delete(String title) {
    int index = indexOf(title);
    if (index < 0 || index >= ArrayList3.size) {
      return 0;
    }
    ArrayList3.remove(index);
    return 1;
  }


  //  @RequestMapping("/board/countup")
  //  static Object countup(String title) {
  //    int index = indexOf(title);
  //    if (index == -1) {
  //      return "";
  //    }
  //    
  //
  //    return ArrayList3.list[index];
  //  }

  static int indexOf(String title) {
    for (int i = 0; i < ArrayList3.size; i++) {
      Board board = (Board)ArrayList3.list[i];  // contact = 주소
      if (board.title.equals(title)) { 
        return i;
      }
    }
    return -1;
  }


}




