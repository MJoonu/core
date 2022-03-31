package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();//close를 ApplicationContext가 지원하지 않기 때문에 바꿔준다.
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean//(initMethod = "init", destroyMethod = "close")//destroyMethod의 경우의 추론적인 특징이 있고.
                                                           //이름이 여러가지 가지고 갈 수 있기 때문에 추론을 가지고간다.(inferred)
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
