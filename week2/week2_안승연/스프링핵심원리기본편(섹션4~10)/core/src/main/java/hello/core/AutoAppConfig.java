package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan ( //Component 붙은 클래스 찾아 자동으로 스프링 빈 등록
//        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
) //excludeFilters는 제외할 것 설정(기존 코드 충돌 없애기 위해 configuration 제외한 것)
public class AutoAppConfig {

}
