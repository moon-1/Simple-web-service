package springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.web.dto.HelloResponseDto;

@RestController
public class HelloController {

    @GetMapping("/hello") // HTTP함수 Get의 요청을 받을 수 있는 API를 만들어줌 > '/hello'로 요청이 오면 문자열 hello를 반환하는 기능을 가짐
    public String Hello(){

        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, //@RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
                                     @RequestParam("amount") int amount) { //외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터 string name에 저장
        return new HelloResponseDto(name, amount);
    }
}
