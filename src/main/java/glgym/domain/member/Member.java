package glgym.domain.member;

import glgym.domain.memberState.MemberState;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String memberNo;
  @OneToOne
  private MemberState memberState;
  private String jerk_record;
  private String snatch_record;
  private String password;
  private Date createdDate = new Date();

  public Member() {}
  public Member(String name, String memberNo,MemberState memberState, String jerk_record, String snatch_record, String password) {
    this.name = name;
    this.memberNo = memberNo;
    this.memberState = memberState;
    this.jerk_record = jerk_record;
    this.snatch_record = snatch_record;
    this.password = password;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public MemberState getMemberState() { return memberState; }
  public void setName(String name) {
    this.name = name;
  }
  public String getMemberNo() {return memberNo; }
  public void setMemberNo(String memberNo) {this.memberNo = memberNo;}
  public String getJerk_record() {return jerk_record; }
  public void setJerk_record() {this.jerk_record = jerk_record; }
  public String getSnatch_record() { return snatch_record; }
  public void setSnatch_record() { this.snatch_record = snatch_record; }
  public String getPassword() { return password; }
  public void setPassword() { this.password = password; }
}
