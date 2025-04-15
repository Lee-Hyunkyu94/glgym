package com.example.glgym.controller;

import com.example.glgym.domain.member.Member;
import com.example.glgym.domain.memberState.MemberState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class Test {

  @GetMapping("/test")
  public String test() {
    return "Hello";
  }

  public Member save(Member member) {
    MemberState memberState = member.getMemberState();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      String sql = "insert into member (name) values (?)";
      pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      pstmt.setString(1, member.getName());
      pstmt.executeUpdate();

      rs = pstmt.getGeneratedKeys();
      if (rs.next()) {
        member.setId();
      }
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
    return member;
  }
}
