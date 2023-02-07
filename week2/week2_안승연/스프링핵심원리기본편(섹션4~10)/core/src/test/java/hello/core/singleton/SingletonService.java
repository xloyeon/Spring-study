package hello.core.singleton;

public class SingletonService {

    //static이므로 딱 하나 생성(클래스 레벨)
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //생성을 막기 위해 private를 이용
    private SingletonService(){
    }
    
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args){
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
    }
}
