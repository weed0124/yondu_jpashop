package jpabook.yondu_jpashop.service.query;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class OrderQueryService {

    /**
     * 컬렉션 데이터를 가지고 오는 처리를 담당하여 필요한 부분에서 호출만 하도록 처리
     */
}
