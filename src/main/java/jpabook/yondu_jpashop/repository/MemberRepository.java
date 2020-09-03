package jpabook.yondu_jpashop.repository;

import jpabook.yondu_jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // select m from Member m where m.name = ?
    // findByXXXX => XXXX에 해당되는 조건 쿼리가 자동으로 생성됨
    List<Member> findByName(String name);
}
