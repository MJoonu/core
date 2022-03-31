package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();

//        ac.getBean("beanB", BeanB.class);
//        org.junit.jupiter.api.Assertions.assertThrows(
//                NoSuchBeanDefinitionException.class,
//                () -> ac.getBean("beanB", BeanB.class)
//        );
    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(classes = MyIncludeComponent.class),
            excludeFilters = @Filter(/*type = FilterType.ANNOTATION,*/classes = MyExcludeComponent.class)
            //FilterType의 기본 설정값은 ANNOTATION 따라서 없어도 실행됨
            //ASSIGNABLE_TYPE - 지정한 타입과 자식타입을 인식해서 동작
            //ASPECTJ - AspectJ 패턴을 사용해서 찾아옴
            //REGEX - 정규 표현식
            //CUSTOM - TypeFilter 라는 인터페이스를 구현해서 처리함.
    )
    static class ComponentFilterAppConfig {

    }
}
