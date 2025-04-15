package com.example.glgym.domain.member;

import com.example.glgym.domain.memberState.MemberState;
import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToOne
  private MemberState memberState;
  private String jerk_record;
  private String snatch_record;
  private String password;

  public Long getId() {
    return id;
  }
  public void setId() {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName() {
    this.name = name;
  }
}
