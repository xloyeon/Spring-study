
> * 스프링 MVC 전체 구조

<br></br>

![](https://velog.velcdn.com/images/bony9728/post/4f3c0a2c-9fd7-46cf-b841-83163a3d653b/image.png)

* 요청 흐름

1. 핸들러 조회
2. 핸들러 어댑터 조회 - 핸들러를 처리할 수 있는 어댑터
3. 핸들러 어댑터 실행
4. 핸들러 어댑터를 통해 핸들러 실행
5. ModelView 반환
6. viewResolver를 통해서 뷰 찾기
7. View 반환
8. 뷰 랜더링


* DispatcherServlet의 코드 변경 없이, 원하는 기능을 변경하거나 확장할 수 있다는 장점

> 핸들러 매핑과 어댑터 

<br></br>


* HandlerMapping 우선 순위
0 = RequestMappingHandlerMapping : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
1 = BeanNameUrlHandlerMapping : 스프링 빈의 이름으로 핸들러를 찾는다.

* HandlerAdapter 우선 순위
0 = RequestMappingHandlerAdapter : 애노테이션 기반의 컨트롤러인 @RequestMapping에서 사용
1 = HttpRequestHandlerAdapter : HttpRequestHandler 처리, 서블릿과 가장 유사한 형태의 핸들러
2 = SimpleControllerHandlerAdapter : Controller 인터페이스 처리

가장 우선 순위가 높은 핸들러 매핑과 핸들러 어댑터는 _RequestMappingHandlerMapping, ReuquestMappingHandlerAdapter_이다. 실무에서는 거의 이 방법을 사용_

>  뷰 리졸버
<br></br>


* 스프링 부트가 자동 등록하는 뷰리졸버 우선순위(아래의 것보다 더 있음)
1 = BeanNameViewResolver : 빈 이름으로 뷰를 찾아서 반환
2 = InternalResourceViewResolver : JSP를 처리할 수 있는 뷰를 반환


* InternalResourceView는 JSP처럼 forward()를 호출해서 처리할 수 있는 경우에만 사용
JSP를 제외한 나머지 뷰 템플릿들은 forward() 과정 없이 바로 렌더링 됨


>  프로젝트 생성 시 JAR VS WAR
>  <br></br>


![](https://velog.velcdn.com/images/bony9728/post/c33fb7a7-7783-47d2-80cc-374a4c60d646/image.png)

* JAR
1. JAR는 자바로 만든 어플리케이션의 구성요소들을 압축시켜 놓은 파일
2. JRE or JDK 환경에서 JAR 파일을 실행 시킬 수 있다.
3. 스프링부트는 내장 톰캣을 포함하고있기 때문에 간단하게 JAR 배포만으로 실행이 가능

* WAR

1. WAR 확장자 파일은 Servlet/ Jsp 컨테이너에 배치할 수 있는 웹 어플리케이션을 압축한 파일
2. WAR는 JAR와 달리 특정 웹 컨테이너의 구조에 맞춰 실행
3. 웹 관련 자원만 포함
4. 주로 외부 서버에 배포하는 목적


#### ----> JSP를 사용하지 않기에 내장 톰켓 기능에 최적화하여 사용할 때 JAR사용

> logging
<br></br>


* 스프링 부트 라이브러리를 사용하면 스프링 부트 로깅 라이브러리가 함께 포함됨
* 기본으로 SLF4J, Logback 로깅 라이브러리를 사용

LogTestController
![](https://velog.velcdn.com/images/bony9728/post/4c00f748-41a1-4e69-b010-28e5cd343baf/image.png)

* @Controller는 바환 값이 String이면 뷰 이름으로 인식 -> 뷰를 찾고 뷰가 랜더링
* @RestController는 HTTP 메시지 바디에 바로 입력 
* 롬북에서 제공하는 @Slf4j 사용시 Logger log 선언 생략 가능
* 로그 레벨 : TRACE > DEBUG > INFO > WARN > ERROR
* 개발 서버는 debug 출력, 운영 서버는 info 출력
* 로그를 사용 시 시스템 아웃 콘솔에만 출력되는 것이 아니라, 파일이나 네트워크 등 로그를 별도의 위치에 남길 수 있음

> 클라이언트에서 서버로 요청 데이터를 전달할 때의 3가지 방법
> <br></br>


1. Get - 쿼리 파라미터
ex) http://localhost:8080/request-param?username=hello&age=20

2. Post - HTML Form
ex)
POST /request-param ...
content-type: application/x-www-form-urlencoded
username=hello&age=20

GET 쿼리 파리미터 전송 방식, POST HTML Form 전송 방식 둘다 형식이 같으므로 구분없이 조회 가능
**
-> 요청 파라미터(request parameter) 조회라고 함
**
3. HTTP message body에 데이터를 직접 담아 요청

HTTP 요청 파라미터 
 @RequestParam vs @ModelAttribute

![](https://velog.velcdn.com/images/bony9728/post/b9cac487-d03a-412c-bac4-f237e586adab/image.png)

\- @ResponseBody는 HTTP message body에 직접 해당 내용을 입력
 (@RestController)와 같은 역할
 
\-@RequestParam의 name(value) 속성이 파라미터 이름으로 사용

![](https://velog.velcdn.com/images/bony9728/post/2a672fc1-f6bc-4897-b746-a25cf1376173/image.png)

\- @ModelAttribute는 HelloData 객체를 생성하고, 요청 파라미터의 값도 모두 들어가게 함
\- 객체 생성 및 setter 호출 기능 생략 가능

\+@ModelAttribute 생략도 가능하지만 주의해야할 점은 String이나 단순 type은 @RequestParam이 자동 적용되고, 임의의 객체인 경우일 경우 @ModelAttribute 자동 적용 이 점을 유의하여 생략할 것


**요청 파라미터를 조회하는 기능 : @RequestParam, @ModelAttribute
**HTTP메시지 바디를 직접 조회하는 기능 : @RequestBody**

> HTTP 응답
<br></br>

1. 정적 리소스
웹 브라우저에 정적인 HTML, css, js를 제공할 때 정적 리소스를 사용
해당 파일을 변경 없이 그대로 서비스

2. 뷰 템플릿 사용
뷰 템플릿을 거쳐서 HTML이 생성, 뷰가 응답을 만들어 전달

> 요청 매핑 핸들러 어뎁터 구조
<br></br>

![](https://velog.velcdn.com/images/bony9728/post/0969325e-e08a-4568-ab54-8f68d3d73d8e/image.png)
* 애노테이션 기반 컨트롤러를 처리하는 RequestMappingHandlerAdapter는 ArgumentResolver를 호출해서 컨트롤러가 필요로 하는 다양한 파라미터의 값을 생성

* ReturnValue Handler는 ArgumentResolver와 비슷 -> 응답 값을 변환하고 처리

> HTTP 메시지 컨버터
<br></br>

![](https://velog.velcdn.com/images/bony9728/post/6806b91f-b61e-4933-a320-e825e7188d5f/image.png)

* 요청의 경우 ArgumentResolver들이 HTTP 메시지 컨버터를 사용해서 필요한 객체를 생성
* 응답의 경우 @ResponseBody와 HttpEntity를 처리하는 ReturnValueHandler가 HTTP 메시지 컨버터를 호출해서 응답 결과를 만들음

<br></br>


![](https://velog.velcdn.com/images/bony9728/post/3dad5abe-d05b-48e5-ae14-853dfc526d58/image.png)

역할 : 핵심 비즈니스 모델을 개발하여 HTML을 뷰 템플릿으로 변환하여 동적으로 화면을 전환시킬 것

컨트롤러와 뷰 템플릿 개발

Model을 통해 뷰를 전달하며,

view 전달 방법
1. 파라미터에 Model 타입의 객체를 선언, 이후 addAttribute()를 통해 전달
2. @ModelAttribute 애노테이션 사용
<br></br>

정적 HTML을 뷰 템플릿 영역으로 복사하여 수정(정적 HTML을 동적으로 변경) -> 타임리프 사용

* 타임리프 문법
\- URL 링크 표현식 @{..}
\- 속성 변경 th:onclick
\- 리터럴 대체 |..|
\- 반복 출력 th:each
\- 변수 표현식 ${..}


\+ 타임리프 사용이유
클라이언트에게 동적인 웹페이지를 보여주기 위해 JSP, Thymeleaf등 다양한 방식이 있는데 스프링에서는 Thymeleaf를 권장 

1. 파일을 .html로 바꿔도 인식할 수 있지만, jsp는 그것이 불가능합니다. .jsp 로 되어있던 file을 .html로 바꾸면 브라우저에서 파일을 인식할 수 없다.

2. 타임리프는 html5를 완벽하게 지원한다. 반면 jsp는 스프링 3.1 버전 전까지 html5를 완벽하게 지원하지 못한다.

참고 https://abcdefgh123123.tistory.com/480
<br></br>

>  상품 수정 시 Redirect 사용 이유

<br></br>

PRG(POST/REDIRECT/GET)

* 상품 수정 시에 Redirect를 사용한 이유 ?
![](https://velog.velcdn.com/images/bony9728/post/b48547cd-651f-40b0-8d7e-7be832e2bcb7/image.png)
POST 등록 후 새로고침을 하면 ID만 다른 상품 데이터가 계속 쌓이게 된다.
-> 웹 브라우저의 새로 고침은 마지막에 서버에 전송한 데이터를 다시 전송하기 때문


REDIRECT를 사용하여 문제 해결
![](https://velog.velcdn.com/images/bony9728/post/7eaf9370-e8ad-49a7-911a-8483da45cbb1/image.png)

웹 브라우저는 리다이렉트의 영향으로 상품 저장 후에 실제 상품 상세 화면으로 다시 이동
![](https://velog.velcdn.com/images/bony9728/post/0d627b2d-2904-4f37-85c7-33fd93b62aea/image.png)

