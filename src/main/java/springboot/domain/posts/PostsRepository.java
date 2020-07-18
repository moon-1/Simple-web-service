package springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostsRepository extends JpaRepository<Posts,Long> { //JpaRepository<Entity class,PK type>
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}

//Repository : JPA에서의 DB Layer 접근자
//Entity class와 기본 Entity Repository는 함께 위치해야함 > 주로 domain package에서 함께 관리

