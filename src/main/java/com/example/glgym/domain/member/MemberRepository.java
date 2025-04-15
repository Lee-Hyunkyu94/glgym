package com.example.glgym.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public interface MemberRepository extends JpaRepository<Member, Long> {
  @Override
  public default Member save(Member member) {
    SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(new JdbcTemplate());
    jdbcInsert.withTableName("MEMBER").usingGeneratedKeyColumns("id");

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("name",member.getName());

    member.setId();
    return member;
  }
}
