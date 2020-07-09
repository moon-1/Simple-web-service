package springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostsRepository extends JpaRepository<Posts,Long> { //JpaRepository<Entity class,PK type>
}

//Repository : JPA에서의 DB Layer 접근자
//Entity class와 기본 Entity Repository는 함께 위치해야함 > 주로 domain package에서 함께 관리

