package jpabook.yondu_jpashop.service;

import jpabook.yondu_jpashop.domain.Member;
import jpabook.yondu_jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("du");
        
        // when
        Long savedId = memberService.join(member);
        
        // then
        em.flush();
        assertEquals(member, memberRepository.findById(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("du");

        Member member2 = new Member();
        member2.setName("du");

        // when
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생해야 한다.

        // then
        fail("예외가 발생해야 한다.");
    }
}