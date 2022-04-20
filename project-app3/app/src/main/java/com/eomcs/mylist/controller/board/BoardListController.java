package com.eomcs.mylist.controller.board;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.controller.Component;
import com.eomcs.mylist.controller.RequestMapping;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

@Component("/board/list")
public class BoardListController {

  BoardService boardService;

  public BoardListController(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping
  public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
    // 1) 입력 데이터 가공 및 검증
    int pageNo = 1;
    int pageSize = 5;
    int totalPageSize = 0;


    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
      if (pageSize < 5 || pageSize > 100) {
        pageSize = 5;
      }
    } catch (Exception e) {}

    // 게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
    int boardSize = boardService.size(); 
    totalPageSize = boardSize / pageSize; // 예) 게시글개수 / 페이지당 개수  = 16 / 5 = 3
    if ((boardSize % pageSize) > 0) {
      totalPageSize++;
    }

    try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
      if (pageNo < 1 || pageNo > totalPageSize) { // pageNo 유효성 검증
        pageNo = 1;
      }
    } catch (Exception e) {}


    // 2) 서비스 객체 실행
    List<Board> boards = boardService.list(pageSize, pageNo);


    // 3) 출력 데이터 준비
    request.setAttribute("list", boards);
    request.setAttribute("pageNo", pageNo);
    request.setAttribute("pageSize", pageSize);
    request.setAttribute("totalPageSize", totalPageSize);

    return "/jsp/board/list.jsp";

  }
}






