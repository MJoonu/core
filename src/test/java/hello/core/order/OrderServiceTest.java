package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;



    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
//            OrderServiceImpl orderService = new OrderServiceImpl();
//            orderService.createOrder(1L, "itemA", 10000);
        // OrderServiceImpl 의 생성자를 수정자로 변경학고 진행한 테스트
        // 생성자 주입을 살려서 진행하면 new OrderServiceImpl(에러); 가 나오는데

        // 값은 nullpointException
    }
}
