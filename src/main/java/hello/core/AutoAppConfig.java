package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",//찾을 위치에 대한 지정.
//        basePackageClasses = AutoAppConfig.class, // 선언된 클래스의 패키지부터 찾음.
        // 지정하지 않을시 ComponentScan 을 붙힌 패키지를 전부 찾는다. default
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 수동 빈 등록과 자동빈 등록의 경우 자동빈이 override 되면서
    // 수동빈을 우선적으로 등록되게 만든다.
    // 최근 부트에서는 수동 빈 자동빈이 충돌하면 override 되는 것이 아닌 그냥 튕기게 수정되었다.
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
