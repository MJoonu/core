package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){}

    public static void logic() {
        System.out.println("singleton 객체 호출 방법");
    }

}
