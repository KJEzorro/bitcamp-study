package com.eomcs.mylist.controller;
import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;;


@RestController
public class BoardController {

  @Autowired
  BoardService boardService;

  @RequestMapping("/board/list")
  public Object list() {
    return new ResultMap().setStatus(SUCCESS).setData(boardService.list());
  }

  @RequestMapping("/board/add")
  public Object add(Board board, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다");
    }
    board.setWriter(member);
    boardService.add(board);
    return new ResultMap().setStatus(SUCCESS);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardService.get(no);
    if (board == null) {
      return new ResultMap().setStatus(FAIL).setData("해당 번호의 게시글이 없습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(board);
  }

  @RequestMapping("/board/update")
  public Object update(Board board, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다");
    }
    board.setWriter(member);
    int count = boardService.update(board);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @RequestMapping("/board/delete")
  public Object delete(int no, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다");
    }

    Board board = new Board();
    board.setNo(no);
    board.setWriter(member);
    int count = boardService.delete(board);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }

  }
}
