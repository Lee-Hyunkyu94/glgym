package glgym.domain.memberState;

import jakarta.persistence.*;

@Entity
@Table (name = "MEMBER_STATE")
public class MemberState {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String name;
  public Long getId() {
    return id;
  }
  public void setId() {
    this.id = id;
  }
}
