package id.pahang.backend4.repository;

import id.pahang.backend4.model.Post;
import id.pahang.backend4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTypeAndPostParentId(int type, Long postParentId);
    List<Post> findByType(int type);
    List<Post> findByUserIdAndType(Long userId, int type);
}
