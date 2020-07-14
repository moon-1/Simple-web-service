package springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication //스프링 부트의 자동 설정, 스프링 Bean읽기와 생성 자동 설정
public class Application { //project main class 해당 클래스는 항상 프로젝트의 최상단에 위치해야함
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);//내장 WAS(웹 애플리케이션 서버) 실행 > 서버에 Tomcat을 설치할 필요 없음
    }//내장 WAS > 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있음
}
