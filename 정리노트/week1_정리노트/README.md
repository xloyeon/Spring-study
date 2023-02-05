# 	📋️ Week1 정리노트  
<hr/>  

## ❓ 왜 객체를 스프링이 생성하고 관리해야 할까?  
<br>

- 스프링 bean이란 '스프링이 생성하고 관리하는 객체(개발자가 직접 생성하지 x)'.
  - 스프링은 객체를 다루기 위한 다양한 보조 기능을 제공하는데, 이를 제공받기 위해서는 객체를 제어하기 위한 주도권을 스프링이 가져가야 함.  
  
<br>

- 스프링 bean의 장점
  1. bean을 통해 의존성 주입이 가능함.
  2. 스프링 IoC 컨테이너에서는 모든 빈들을 싱글톤 객체로 생성하는데, 객체를 싱글톤(레지스트리)으로 관리하는 게 좋음.
     - 싱글톤으로 bean을 생성하게 되면 요청 당 객체를 생성할 일이 줄어들어(처음에만 생성하면 되므로) 서버의 성능을 높일 수 있음.
     - 따라서 초기에 설정하면 사용중에는 변하지 않은 경우라면 bean으로 등록하고 사용하는 것이 좋음.
  3. 라이프 사이클 관리가 용이함.    
  
<br>

[출처]
- [스프링 Bean(빈) 사용하는 이유, 장점](https://thiago6.tistory.com/158)
- [Bean, IoC(Inverstion of Control)](https://siyoon210.tistory.com/3)
- [왜 스프링은 싱글톤으로 bean을 만드는가?](https://datajoy.tistory.com/112)  
  
<br>
<hr/>

## 💡 의존성 주입을 사용하는 이유와 생성자 주입 방식을 선호하는 이유  
<br>

- 의존성 주입을 사용하는 이유
  1. '의존한다'는 것은 의존대상의 변화에 취약하다는 단점이 있음(의존 대상이 변화하면 의존하는 대상도 변화해야 함).
     - DI를 사용하면 주입받는 대상이 변하더라도 수정할 일이 줄어듦.
  2. 재사용성이 높은 코드가 될 수 있음.
  3. 테스트하기 편리해짐.  

<br>

- 생성자 주입 방식을 선호하는 이유
  1. 객체의 불변성을 확보할 수 있음.
     - 실제로는 의존관계의 변경이 필요한 상황이 거의 없으므로, 불필요하게 수정의 가능성을 열어두는 것보다 불변성을 보장하는 생성자 주입방식이 좋음.
  2. 테스트 코드 작성 용이
     - 테스트는 가능한 순수 자바로 작성하는 것이 가장 좋음.
     - 생성자 주입 방식은 컴파일 시점에 객체를 주입받아 테스트 코드를 작성할 수 있음.
     - 생성자 주입 방식에서는 주입 객체가 누락된 경우 컴파일 시점에 오류를 발견할 수 있음.
  3. 순환 참조 에러를 객체 생성 시점에 파악해 방지할 수 있음.

    
<br>

[출처]
- [의존관계 주입(Dependency Injection) 쉽게 이해하기](https://tecoble.techcourse.co.kr/post/2021-04-27-dependency-injection/)
- [[Spring] 다양한 의존성 주입 방법과 생성자 주입을 사용해야 하는 이유 - (2/2)](https://mangkyu.tistory.com/125)  

<br>
<hr/>


## 💡 AssertJ로 테스트 코드 작성하기(+JUnit과 AssertJ의 비교)  
<br>

- main 메소드로 테스트 작성 시 문제점  
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Feuiy0o%2FbtrdUno4hZq%2FDp3J6iEd82tPkNGzMMkfp0%2Fimg.png" width="600" height="400"/>
  1. 테스트 결과를 수동으로 확인해야 함.
  2. 메소드 이름을 통해 어떤 테스트를 하는지 의도를 나타내기 어려움.
  3. Production code와 test code가 클래스 하나에 존재해 복잡도가 증가합.
  4. main 메소드 하나에서 여러 개의 기능을 테스트해 복잡도가 증가함.    

<br>

- JUnit의 assertThat보다 AssertJ의 assertThat을 사용해야 하는 이유
  1. 자동완성 기능 포함
     - assertThat에서 반환되는 Assert 클래스를 사용하여 메소드 자동완성 기능이 지원됨.
  2. Assertion 분류
     - assertThat에서 인자의 타입에 맞는 Assert 클래스를 반환하여 필요한 메소드만 분류되어 있음.
     - 따라서 필요한 메소드를 검색하고 찾아 import해야 하는 번거로움이 없음.
  3. 확장성
     - 체이닝 메소드 패턴으로 작성 가능해, 조건 추가시 추가 작업이 필요없어 편리하고 가독성이 좋음.
  4. 직관적인 함수명  

<br>

[출처]
- [JUnit, AssertJ, 단위테스트 개념 및 다양한 활용법](https://jminie.tistory.com/68)
- [JUnit의 assertThat보다 assertj의 assertThat을 써야하는 이유](https://jwkim96.tistory.com/168)