package hello.core.lifecycle;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 초기화, 소멸 코드는 spring전용 코드이기에 스프링 의존적이 되며
// 외부 라이브러리에 적용이 불가능함.
// 스프링 초창기의 방법으로 지금은 사용하지않는 수준
public class NetworkClient //implements InitializingBean, DisposableBean
{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message){
        System.out.println("call : " + url + "message = " + message);
    }
    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }


    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }


    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
