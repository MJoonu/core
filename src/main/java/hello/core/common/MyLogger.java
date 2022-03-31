package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 특수스코프, 코드 구조가 싱글톤과 비슷하기 때문에 헷갈려서 유지보수하기 어려워 질 수 있음.
                                                                    // 주의할것.
public class MyLogger {

    private String uuid;
    private String requsetURL;

    public void setRequsetURL(String requsetURL) {
        this.requsetURL = requsetURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "["+requsetURL+"] "+message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close " + this);
    }
}
