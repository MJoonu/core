package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    //이 @MyExcludeComponent 가 붙으면 컴포넌트 스켄 대상 제외
}
