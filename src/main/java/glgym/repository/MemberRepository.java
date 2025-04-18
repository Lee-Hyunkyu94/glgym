package glgym.repository;

import glgym.domain.member.Member;

import java.util.*;

public class MemberRepository{

  private static Map<Long, Member> store = new HashMap<>();
  private static long sequence = 0L;

  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  public Optional<Member> findById(Long id) {
    return Optional.ofNullable(store.get(id));
  }

  public Optional<Member> findByMemberNo(String memberNo) {
    return store.values().stream()
            .filter(member -> member.getMemberNo().equals(memberNo))
            .findAny();
  }

  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }
}
