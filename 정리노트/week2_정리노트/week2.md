#  Week2 정리노트  
<hr/>  

## Spring Bean 등록 방법(@Configuration, @Component)
<br>

- [빈 등록 5가지](https://wordbe.tistory.com/entry/Spring-IoC-%EB%B9%88-%EB%93%B1%EB%A1%9D-%EB%B0%A9%EB%B2%95-5%EA%B0%80%EC%A7%80)

<br>

@Component vs @Configuration
 
  @Component
  개발자가 직접 작성한 클래스를 빈으로 등록하고 싶을 때 사용
  @Configuration
  개발자가 직접 제어가 불가능한 외부 라이브러리 또는 설정을 위한 클래스를 Bean으로 등록할 때 사용
  
  CGLIB(Code generation library)이 두 애노테이션 마다 다르게 동작
  
- [@Configuration vs @Component](https://m.blog.naver.com/sthwin/222131873998)
  

<hr/>

## 싱글톤 컨테이너
<br>

스프링 컨테이너는 싱글톤 컨테이너 역할을 한다. 이처럼 싱글톤 객체를 생성및 관리하는 기능을 싱글톤 레지스트리


<br>

 @Configuration, 바이트 코드 조작 라이브러리 CGLIB

\- 스프링에서는 싱글톤 패턴을 보장하기 위해 @Configuration 설정 시 사용자가 만든 클래스를 스프링 빈에 등록하는 것이 아니라 해당 클래스를 상속받은 임의의 클래스를 만들고 그 클래스를 스프링 빈으로 등록합니다.


\- @Configuration이 없다면 ?
싱글톤 패턴을 유지 X.
@Bean 선언은 돼있기 때문에 각 메서드들이 스프링 빈으로 등록
객체를 생성할 때마다 각각 별도로 스프링 빈에 등록

- [싱글톤 컨테이너 참고](https://ksr930.tistory.com/275)
    

<hr/>

<hr>

## 의존관계 주입 : 생성자 주입 사용할 것
<br>

\- 객체의 불변성 확보
\- 테스트 코드의 작성
\- final 키워드 작성 및 Lombok과의 결합
\- 스프링에 비침투적인 코드 작성
\- 순환 참조 에러 방지 

- [생성자 주입관련 참고](https://mangkyu.tistory.com/125)

</br>

</hr>

<hr>
## 빈 생명주기 콜백
<br>

애플리케이션 시작과 종료 시점에 필요햔 연결을 미리 하고 종료하기위해서는 객체의 초기화와 종료 작업이 필요

1. 빈 등록 초기화, 소멸 메서드 지정

2. @PostConstruct, @PreDestroy 애노테이션 지원


외부 라이브러리에 적용할 경우에는 @Bean의 initMethod 와 destroyMethod를 쓸 것

</br>

</hr>

<hr>
## 프로토타입 스코프 - 싱글톤 빈과 함께 사용시 / 웹 스코프와 프록시
<br>


프로토타입 스코프와 싱글톤 빈을 함께 사용 시 문제점 해결방법
* ObjectFactory, ObjectProvider
\- prototypeBeanProvider.getObject()을 통해서 항상 새로운 프로토타입 빈이 생성된다.
\- getObject()를 호출하면 DL기능 작동

* JSR-330 자바 표준을 사용
\- provider.get()을 통해서 항상 새로운 프로토타입 빈이 생성된다.
\- get()을 호출할 시 DL기능 작동
\- 별도의 라이브러리가 필요

코드를 스프링이 아닌 다른 컨테이너에서도 사용할 수 있어야한다면 JSR-330 Provide를 사용할 것 

</br>

<br>
웹 스코프의 경우 HTTP 요청이 들어올 때 새로 생성되고 응답하면 사라짐. 싱글톤 빈이 생성되는 시점에는 아직 생성되지 않음에 따라 의존관계 주입이 불가능

프록시를 이용하여 해결
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)

CGLIB라는 라이브러리로 내 클래스를 상속 받은 가짜 프록시 객체를 만들어서 주입, 의존관계 주입도 가짜 프록시 객체가 주입

즉, 진짜 객체 조회를 꼭 필요한 시점까지 지연처리를 한다.
</br>

</hr>
