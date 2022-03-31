package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component/*(service) bean name 충돌 */
//@RequiredArgsConstructor//final이 붙은 필드를 사용해서 생성자를 생성해줌...
public class OrderServiceImpl implements OrderService{

    //필드 주입 - 외부에서 변경할 수 없어서 테스트 하기 힘들기에
    //          잘 사용하지 않는다.
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //수정자 작성시에는 final을 지워줄 것

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    /*3/27 수정자
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }
    */

    //일반 메서드 주입
    // 한번에 여러필드를 주입받을 수 있으나
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    //수정자가 있을때는 생성자가 있을 필요가 없음.
    //필드 주입시에는 생성자가 필요없음
    //@Autowired//생성자가 하나만 있을때는 Autowired를 적지 않아도 같은 효과를 냄.




    //test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
