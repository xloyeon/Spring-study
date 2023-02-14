# 서블릿
- http 통신에서 개발자가 핵심 로직을 구현하는 데에만 집중할 수 있게 http 요청과 응답을 간단한 메서드 호출만으로 다룰 수 있게 해주는 기술


# WAS (Web Application Server)
- 정적 컨텐츠 뿐아니라 다양한 로직을 처리하는 동적 컨텐츠 제공
- 우리가 이용하는 스프링부트에 내장된 톰캣도 WAS의 일종


# 서블릿 컨테이너
- 서블릿들의 생성, 실행, 삭제를 담당
- 서블릿을 지원하는 WAS들을 서블릿 컨테이너라고 함 (예: 톰캣)


# 템플릿 엔진
- html 양식에 동적인 컨텐츠(데이터) 를 합쳐 html문서를 만들어주는 기술
- 우리가 이용할 서버 사이드 템플릿 엔진으로는 jsp, 타임리프 등이 있음. 최근에는 타임리프가 선호, 스프링도 타임리프 이용을 권장

https://code-lab1.tistory.com/211


# 그래서 스프링 MVC의 핵심은? MVC패턴과 FrontController패턴
### MVC패턴
애플리케이션을 Model, View,  Controller 세 가지 역할로 구분하여 개발하는 방법론
장점
- 비즈니스 로직과 UI로직을 분리하여 유지보수를 독립적으로 수행가능
- Model과 View가 다른 컴포넌트들에 종속되지 않아 애플리케이션의 확장성, 유연성에 유리함
- 중복 코딩의 문제점 제거
 
https://cocoon1787.tistory.com/733

### FrontController 패턴

장점
- 공통 코드 처리가 가능 (MVC 패턴만을 이용했을 때의 문제점이였음.)
- Front Controller 외 다른 Controller에서 Servlet 사용하지 않아도 됨
![image](https://user-images.githubusercontent.com/25169200/218739858-2eb6f3df-17ca-4e78-9e6b-749eeb6c7b32.png)
