package springboot.web.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}

    /*Entity class : 데이터베이스와 맞닿은 핵심 클래스 > Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경됨
        > Entity class 를 Request/Response 클래스로 사용해서는 안됨
        Request/Response용 Dto는 View를 위한 클래스라 자주 변경이 필요함
        View Layer와 DB Layer는 역할 분리를 철저하게 하는 것이 좋음
     */

