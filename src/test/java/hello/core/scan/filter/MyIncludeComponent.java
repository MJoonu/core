package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    //이 @MyIncludeComponent 가 붙으면 컴포넌트 스캔 대상화
}
