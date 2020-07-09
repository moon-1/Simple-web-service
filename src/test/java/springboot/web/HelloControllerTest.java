package springboot.web;

import org.apache.catalina.security.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)//springboot test와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
// spring test annotation, Web에 집중할 수 있는 annotation
public class HelloControllerTest {

    @Autowired//spring이 관리하는 Bean을 주입 받음
    private MockMvc mvc;// 웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))// MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk())// mvc.perform의 결과 검증 : HTTP header의 status 검증
                .andExpect(content().string(hello));// mvc.perform : 응답 본문의 내용 검증
    }
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)// API를 테스트할때 사용될 요청 파라미터 설정 (값은 string만 허용)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))//JSON 응답값을 필드별로 검증할 수 있는 메소드 ($기준으로 필드명 명시)
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
