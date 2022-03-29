package com.eomcs.mylist.controller;

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
    return memberService.add(member);
  }

}
