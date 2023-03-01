# 	📋️ Week5 정리노트
<hr/>  

## 타임리프 - 기본 기능

> 타임리프의 특징 
<br>
- 내추럴 템플릿
  - 순수 HTML을 그대로 유지하면서 뷰 템플릿도 사용할 수 있는 타임리프의 특징
  - 다른 뷰 템플릿들은 웹 브라우저에서 파일을 열면 깨져보이는 반면, 타임리프는 웹 브라우저에서 파일을 직접 열어도 정상적으로 결과를 확인할 수 있음.
  - 단, 동적인 결과는 랜더링 후에 확인 가능함.   

<br>

> 타임리프 선언

    <html xmlns:th="http://www.thymeleaf.org">
   
<br>

> 타임리프 기본 기능들

1. 텍스트 - text, utext

- HTML 엔티티 : 태그로 사용되는 문자를 태그가 아니라 문자로 인식할 수 있도록 표현하는 방법   
   

- Escape
  - HTML에서 사용하는 특수 문자를 HTML 엔티티로 변경하는 것을 말함 
  - `th:text` : HTML 컨텐츠에 데이터를 출력할 때 사용
  - `[[...]]` : HTML 컨텐츠 영역 안에서 직접 데이터를 출력하고 싶을 때 사용   
   

- UnEscape
  - 이스케이프 기능을 사용하지 않는 경우
  - `th:utext`, `[(...)]`   
   

<br>
<hr>

2. 변수 - SpringEL   

- 변수 표현식(`${...}`) : 타임리프에서 변수 사용시 사용해야 함   


- SpringEL : 스프링이 제공하는 변수 표현식, 프로퍼티 접근으로 변경해 가져옴


<br>
<hr>

3. 기본/편의 객체들   

- 기본 객체들 : `${#request}`, `${#response}`, `${#session}`, `${#servletContext}`, `${#locale}`   
   

- 편의 객체들 : `${param.paramData}`, `${session.sessionData}`, `${@helloBean.hello('Spring!')`   


<br>
<hr>   

4. 유틸리티 객체들   

- 타임리프는 문자, 숫자, 날짜, URL 등을 편리하게 다루는 유틸리티 객체들을 제공함   
   

- 타임리프에서 자바 8 날짜인 LocalDate, LocalDateTime, Instant를 사용하려면 추가 라이브러리가 필요함   
   

- 스프링 부트 타임리프 이용 시 라이브러리가 자동으로 추가되고 통합됨   


<br>
<hr>   

5.URL 링크   
- 단순한 URL : `@{...}`
   

- 쿼리 파라미터 : `@{/hello(param1=${param1}, param2=${param2})}`   
  - '()'안의 부분이 쿼리 파라미터로 처리됨
   

- 경로 변수 : `@{/hello/{param1}/{param2}(param1=${param1}, param2=${param2})}`   
  - URL 경로 상에 '{}'가 있으면 변수이므로 '()'안의 부분이 경로 변수로 처리됨
   

- 경로 변수 + 쿼리 파라미터 : `@{/hello/{param1}(param1=${param1}, param2=${param2})}`   


<br>
<hr>   
6. 리터럴(literals)   

- 소스 코드 상에 고정된 값으로, 타임리프는 문자, 숫자, 불린, null 리터럴을 가짐   
   

- 타임리프에서 문자 리터럴은 항상 ''으로 감싸야 함   
   

- 리터럴 대체 : "|hello ${data}|"   


<br>
<hr>   
7. 연산   

- 비교 연산자 : HTML 엔티티를 사용하므로 주의해야 함   


- 조건식 : 자바와 유사함   
   

- Elvis 연산자(`${data}?`) : 데이터가 없는 경우를 조건식으로 사용   


- no-operation : '_'인 경우 타임리프 효과가 무효화되고 기본이 출력됨   


<br>
<hr>

8. 속성 값 설정   

- 'th:*`
  - 타임리프는 HTML 태그에 `th:*`으로 속성을 지정하는 방식으로 동작함  
  
  - `th:*`은 기존 속성을 대체하고, 없으면 새로 만듦   



<br>
<hr>   

9. 반복   

- `th:each` : 태그를 반복 실행   


<br>
<hr>   


10. 조건부 평가   

- `th:if`, `th:unless` : 해당 조건에 맞지 않으면 태그 자체를 랜더링하지 않음   


- `switch` : case 여러 개에 대한 조건문, `*` 옵션은 조건이 없는 경우(나머지)


<br>
<hr>   

11. 주석   

- HTML 주석 : 타임리프가 랜더링하지 않고 남겨둠   


- 타임리프 파서 주석 : 타임리프의 진짜 주석으로 랜더링에서 주석 부분을 제거함   


- 타임리프 프로토타입 주석 : 타임리프 랜더링 한 경우에만 정상적으로 보이는 주석   


<br>
<hr>   

12. 템플릿 조각 / 템플릿 레이아웃   

- 템플릿 조각 : 공통영역의 변경과 사용을 편리하게 하기 위해 템플릿 조각으로 만들어 사용   
   

- 템플릿 레이아웃 : 템플릿 레이아웃은 레이아웃에 필요한 조각을 레이아웃에 넘겨서 변경, 완성하는 방식   
   

- 레이아웃 확장 : 템플릿 레이아웃이 부분의 변경이라면, 확장은 필요한 내용을 전달하면서 HTML 자체를 변경함


<br>

## 타임리프 - 스프링 통합과 폼    
   

> 입력 폼 처리   
   
- `th:object` : 커맨드 객체를 지정   


- `*{...}` : 커맨드 객체에 소속된 변수로 생각   


- `th:field` : id, name, value 속성을 자동으로 만들어 줘 편리함   
   
<br>

> 체크박스
   
- 체크박스의 문제점   
  - 박스 언체크 시 필드 자체가 서버로 전송되지 않아 null이 됨   
  - 수정 시에 아무 값도 넘어가지 않아 값이 오지 않은 것으로 판단해 변경되지 않을 수도 있음
   

- 스프링 mvc에서의 해결 방법
  - 체크박스 필드명 앞에 언더스코어(_)를 붙여서 전송하면 해제했다고 인식
  - 즉, 언더스코어가 붙은 필드(히든 필드)가 하나 더 있어야 함   

   
- 타임리프의 해결 방법
  - 타임리프를 사용하면 히든 필드와 관련한 부분을 자동으로 생성해 줘 편리함   
   
<br>  

> 라디오 버튼, 셀렉트 박스   
   
- 라디오 버튼과 셀렉트 박스는 히든 박스가 불필요함



<br>

## 메시지, 국제화   

> 메시지, 국제화란   
   
- 메시지 기능 
  - 다양한 메시지를 한 곳에서 관리하도록 하는 기능   
  - 메시지 변경 시 일일히 찾아서 변경하지 않아도 돼 편리함   
  - 메시지 관리용 파일을 생성하고, 각 HTML들에서 파일에 저장되어 있는대로 key 값으로 불러와 사용함   

   
- 국제화   
  - HTTP accept-language를 사용해 언어를 인식하거나, 사용자가 언어를 직접 선택하게 함   
  - 언어별로 메시지 파일을 여러 개 두어 관리할 수 있음   

<br>  

> 스프링 메시지 소스 설정   
   
- 스프링의 메시지 관리 기능을 사용하려면, MessageSource를 스프링 빈으로 등록해야 함   
   

- 스프링 부트는 MessageSource를 자동으로 스프링 빈으로 등록해 줌   


- `basenames`   
  - 설정 파일의 이름을 지정   
  - 여러 파일을 한 번에 지정 가능   


<br>

> 스프링 메시지 소스 사용   
   
- `messageSource.getMessage(code, args, defaultMessage, locale)`
  - code : 메시지   
  - args : 매개변수   
  - locale : 국제화 파일 정보, null이면 시스템의 기본 locale 찾아 사용, 구체적인 것부터 찾고 없으면 디폴트 순서로 찾음   
  - defaultMessage : 메시지가 없는 경우 `NoSuchMessageException`이 발생하나, defaultMessage 인자를 넣어 메시지가 없는 경우 기본 메시지가 반환되도록 함
   

<br>  

## 검증 1 - Validation   

> BindingResult   
   
- `BindingResult`
  - Errors 인터페이스를 상속받은 인터페이스
  - 스프링이 제공하는 검증 오류를 보관하는 객체로, 검증 오류가 발생하면 오류 객체를 생성하여 BindingResult 객체에 보관 
  - `BindingResult`가 있으면 `@ModelAttribute`에 데이터 바인딩 시 오류가 발생해도 오류 정보를 BindingResult에 담아서 컨트롤러가 정상 호출됨
  - 반대로, `BindingResult`가 없으면 컨트롤러가 호출되지 않고 오류 페이지로 이동함   
  - `BindingResult` 파라미터의 위치는 반드시 검증할 대상 바로 뒤에 와야 함
  - `BindingResult`는 자동으로 `Model`에 포함됨  
     
   
<br>   

```
❓ @ModelAttribute가 두 개라면 BindingResult 파라미터의 위치는 어디여야 할까?

- 두 개의 @ModelAttribute 뒤에 각각 작성해주어야 함
```
[출처 - 인프런 질문게시판](https://www.inflearn.com/questions/245721/modelattribute%EA%B0%80-%ED%95%9C-%EA%B0%9C%EA%B0%80-%EC%95%84%EB%8B%90-%EA%B2%BD%EC%9A%B0%EC%97%90%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%ED%95%98%EB%82%98%EC%9A%94)



<br>  

> 타임 리프의 오류 처리   

- `#fields` : `BindingResult`가 제공하는 검증 오류에 접근 가능   


- `th:error` : 해당 필드에 오류가 있는 경우 태그를 출력   
   

- `th:errorclass` : `th:field`에서 지정한 필드에 오류가 있으면 class 정보 추가   


- `th:field` : 정상 상황에서는 모델 객체의 값을 사용하고, 오류 발생 시에는 오류 이전에 입력한 값을 보관했다가 재사용   
   

<br>   

> 오류 메시지    
   
- `errors.properties` : 오류 메시지 파일 생성해서 메시지 코드와 메시지 등록   


- 스프링 부트 메시지 설정 추가 : `spring.messages.basename=messages,errors`   


- `bindingResult.rejectValue()`, `reject()`
  - `BindingResult`가 객체에 대한 정보를 갖고 있는 것을 이용해 특정 필드를 거부(reject)하는 방식으로 에러를 생성하는 메서드
  - `rejectVale()`는 특정 필드에 대한 거부   
  - `reject()`는 글로벌에 대한 거부    
   
   
- 오류 코드와 메시지 처리   
  - 단순하게 만들면 범용성이 올라가 공통으로 사용할 수 있으나, 세밀하게 작성이 어려움   
  - 반대로 너무 자세하게 만들면 범용성이 떨어짐   
  - 가장 좋은 방법은 범용으로 사용하되, 세밀한 작성이 필요한 경우 세밀한 메시지가 적용되게 하는 것임   
  - 이렇게 우선순위에 따라 메시지를 관리해주는 것이 `MessageCodesResolver`   
   
   
- `MessageCodesResolver`   
  - `rejectValue()`, `reject()`는 내부에서 `MessageCodesResolver`를 사용   
  - `MessageCodesResolver`를 통해 생성된 순서대로 오류 코드를 보관함   
  - 생성된 메시지를 순서대로 찾아서 활용 가능함   
  - 범용성 있는 Error의 경우 덜 구체적으로, 특별한 경우 구체적으로 작성해 관리할 수 있음   \
   


<br>  

> Validator 분리   
   
- 검증 로직을 Validator 인터페이스 구현체로 분리
  - 직접 호출해서 사용   
  - Validator를 스프링 빈에 등록하여 주입

   
- WebDataBinder   
  - 스프링의 파라미터 바인딩 역할 및 검증기능 포함   
  - 스프링의 Validator 인터페이스를 사용해 검증기를 만들면 스프링의 추가적인 도움을 받을 수 있음 
  - 적용하기 위해서는 `@ModelAttribute` 앞에 `@Validated` 애노테이션을 추가해야 함
   
   
- `@Validated`   
  - 검증기를 실행하라는 애노테이션   
  - `@Valid`도 사용 가능함   
  - `@Validated`는 스프링 전용, `@Valid`는 자바 표준 
  

<br>   


##검증2 - Bean Validation   


> Bean Validation   
  
- Bean Validation이란   
  - 애노테이션과 여러 인터페이스의 모음   
  - 보통 하이버네이트 Validator를 구현체로 많이 사용함   
  - 검증 로직을 모든 프로젝트에 적용할 수 있도록 공통화, 표준화한 것
  - 애노테이션 하나로 검증로직을 편리하게 적용할 수 있음   


- 검증 애노테이션   
  - `NotBlank` : 빈 값 + 공백만 있는 경우를 허용하지 않음   
  - `@NotNull` : null을 허용하지 않음   
  - `@Range(min=1000, max = 1000000)` : 범위 안의 값만 허용함   
  - `@Max(9999)` : 최대 9999까지만 허용   
  - [더 많은 검증 애노테이션](https://docs.jboss.org/hibernate/validator/6.2/reference/en-US/html_single/#validator-defineconstraints-spec)

   
<br>   

> Bean Validation - 스프링 적용   
   

- 스프링 MVC의 Bean Validator 사용 
  - 스프링 부트가 `spring-boot-starter-validation` 라이브러리를 넣으면 자동으로 Bean Validator를 인지하고 통합함   

   
- 스프링 부트의 글로벌 Validator 사용   
  - 스프링 부트는 `LocalValidatorFactortyBean`을 글로벌 Validator로 등록함   
  - 이 Validator는 애노테이션을 보고 검증을 수행함   
  - 검증 오류가 발생하면 `FieldError`, `ObjectError`를 생성해 `BindingResult`에 담아줌   
   
   
- 검증 순서   
  - `@ModelAttribute` 각각의 필드에 타입 변환 시도   
  - 변환에 성공한 필드만 BeanValidation 적용, 실패 시 `FieldError` 추가   
   
   
<br>   
   
> Bean Validation - 에러 코드   
   
- BeanValidation 메시지 찾는 순서   
  - 생성된 메시지 코드 순서대로 `messageSource`에서 메시지 찾기   
  - 애노테이션의 `message` 속성 사용   
  - 라이브러리가 제공하는 기본 값 사용   

   
<br>   
   
> Bean Validation - 오브젝트 오류   
   
- `@ScriptAssert()`   
  - 특정 필드가 아닌 해당 오브젝트 관련 오류를 처리할 때 사용   
  - 제약이 많고 복잡해 권장하지 않음   
  - [JAVA 11에 종속적임](https://jaimemin.tistory.com/1883)
  - 오브젝트 오류 관련 부분만 직접 자바 코드로 작성하는 것을 권장함   
   
   
<br>   
   
> Bean Validation - groups   
   
- Bean Validation의 한계 : 한 검증 대상에 대해 검증 조건의 충돌이 발생할 수 있음   
   
   
- groups   
  - Bean Validation에서 동일한 객체에 대해 각각 다르게 검증하는 방법으로 제공하는 기능   
  - 각각 다른 요구사항에 대해 검증할 기능을 그룹으로 나누어 적용 가능함 (ex - 등록시 검증 기능 group, 수정시 검증 기능 group)   
  - 복잡도가 올라가 잘 사용하지 않음   
   
   
- Form 전송을 위한 별도의 모델 객체를 만들어 사용   
  - 복잡한 폼의 데이터를 컨트롤러까지 전달할 별도의 객체를 만들어 전달함    
  - 컨트롤러는 폼 객체를 통해 폼 데이터를 전달받고, 컨트롤러가 폼 데이터를 사용해 도메인 객체를 생성함   
  - 전송하는 폼 데이터가 복잡해도 이에 맞춘 별도의 폼 객체를 사용해 데이터를 전달 받을 수 있음   
  - 별도의 폼 객체를 만들어 사용하기에 검증이 중복되지 않음   
   
   
<br>   
   
> Bean Validation - HTTP 메시지 컨버터   
   
- `@Valid`, `@Validated`는 `@RequestBody`에서도 사용 가능   
  - `@ModelAttribute`는 HTTP 요청 파라미터를 다룰 때 사용   
  - `@RequestBody`는 HTTP Body의 데이터를 객체로 변환할 때 사용 (ex- API JSON 요청 다룰 때)   
   
   
- `@ModelAttribute` vs `@ResponseBody`  
  - `@ModelAttribute`는 필드 단위로 정교하게 바인딩이 적용됨  
  - 따라서 `@ModelAttribute`는 특정 필드가 바인딩 되지 않아도 나머지 필드는 정상처리되고 Validator를 사용해 검증 가능함   
  - `HttpMessageConverter`는 필드 단위가 아니라 전체 객체 단위로 적용됨
  - 따라서 `@RequestBody`는 `HttpMessageConverter`단계에서 JSON 데이터를 객체로 변경하지 못하면, 이후 단계가 모두 진행되지 않고 예외가 발생함
   
   
<br>     
   
> Bean Validation에 대한 더 자세한 설명   

- [Spring-Boot Bean-Validation 제대로 알고 쓰자](https://kapentaz.github.io/spring/Spring-Boo-Bean-Validation-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90/#)

   

   

   


