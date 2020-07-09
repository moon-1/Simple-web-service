package springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter//Lombok annotation 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor // Lombok annotation 기본생성자 자동 추가 = public post(){ }
@Entity//JPA annotation 테이블과 링크될 클래스임을 나타냄
public class Posts { //DB의 테이블과 매칭될 클래스 (Entity class)

    @Id//해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)// PK의 생성규칙
    private Long id; //Entity의 PK는 Long타입의 Auto_increment를 추천

    @Column(length = 500, nullable = false)//테이블의 칼럼 > 굳이 선언하지 않아도 해당 클래스필드는 모두 칼럼이 됨
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)//추가하고 싶은 옵션이 있을 경우 사용함
    private String content;

    private String author;

    @Builder// 해당 클래스의 빌더 패턴 클래스 생성성
   public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
/* getter/setter를 무작정 생성할 경우 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로 명확하게 구분할 수가 없게됨
    > 차후 기능 변경 시 복잡해짐

    따라서  Entity class에는 절대 setter 메소드를 만들지 않음
    대신 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야함
 */