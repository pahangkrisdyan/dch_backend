package id.pahang.backend4.repository;

import id.pahang.backend4.model.User;
import id.pahang.backend4.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>  {
    List<Vote> findByPostId(Long postId);
    List<Vote> findByPostIdAndUserId(Long postId, Long userId);
}
