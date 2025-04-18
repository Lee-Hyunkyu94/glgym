package glgym.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import glgym.domain.member.Member;
import glgym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
  ObjectMapper objectMapper = new ObjectMapper();

  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping(value = "/members")
  public List<Member> index() {
    List<Member> members = memberService.findMembers();
    return members;
  }
  @GetMapping(value = "/member")
  public Optional<Member> getMember(@RequestParam(value = "id") Long id) {
    Optional<Member> member = memberService.findOne(id);
    return member;

  }

  @PostMapping(value = "/member/new")
  public void save(@RequestBody HashMap<String, String> requestData) {
    Member member = new Member();
    String memberNo = requestData.get("memberNo");
    String name = requestData.get("name");
    member.setName(name);
    member.setMemberNo(memberNo);

    memberService.join(member);
  }
}
