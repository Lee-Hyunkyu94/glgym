package glgym.repository;

import glgym.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface CommonRepository {
  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByMemberNo(String memberNo);
  List<Member> findAll();

}
