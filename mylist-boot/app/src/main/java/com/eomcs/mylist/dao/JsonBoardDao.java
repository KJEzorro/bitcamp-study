package com.eomcs.mylist.dao;

import java.io.File;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Board;
import com.fasterxml.jackson.databind.ObjectMapper;
// @Repository
// - 클래스에 이 애너테이션을 붙여 표시해 두면, Spring Boot가 실행될 때 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.
@Repository   
public class JsonBoardDao extends AbstractBoardDao {  

  String filename = "boards.json";

  public JsonBoardDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();

      //      TypeFactory 타입정보생성기 = mapper.getTypeFactory();
      //      CollectionType 컬렉션타입정보 = 타입정보생성기.constructCollectionType(
      //          List.class,   // 컬렉션의 타입 
      //          Board.class); // 컬렉션에 들어갈 항목의 타입
      //      Collection<Board> list = mapper.readValue(new File(filename), // JSON 데이터
      //          컬렉션타입정보// 생성할 목록의 타입 정보(JavaType 객체)
      //          );
      //      boardList.addAll(list);

      // 위의 코드를 간단하게 한것.
      boardList.addAll(mapper.readValue(new File(filename),
          mapper.getTypeFactory().constructCollectionType(List.class, Board.class)));
      //      boardList.addAll(mapper.readValue(new File(filename), new TypeReference<List<Board>>() {}));

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생");
    }
  }

  @Override
  protected void save() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), boardList.toArray());
  }

}











