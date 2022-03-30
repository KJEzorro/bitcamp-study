package com.eomcs.mylist.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.MemberService;

@RestController
public class MemberController {

  @Autowired
  MemberService memberService;


  @RequestMapping("/member/signup")
  public Object signUp(Member member) {
    if (memberService.add(member) == 1) {
      return "success";
    } else {
      return "fail";
    }
  }

  @RequestMapping("/member/signin")
  public Object signIn(String email, String password, HttpSession session) {
    Member loginUser =  memberService.get(email, password);
    if (loginUser == null) {
      return "fail";
    }

    // 로그인이 성공하면,
    // 다른 요청을 처리할 때 로그인 회원의 정보를 사용할 수 있도록 세션에 보관한다.
    session.setAttribute("loginUser", loginUser);
    return "success";
  }

  @RequestMapping("/member/getLoginUser")
  public Object getLoginUser(HttpSession session) {
    Object member = session.getAttribute("loginUser");
    if (member != null) {
      return new ResultMap()
          .setStatus("success")
          .setData(member);
    } else {
      return new ResultMap()
          .setStatus("fail")
          .setData("로그인 하지 않았습니다.");
    }

  }




}
