package com.niladri.linkedin.post_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.niladri.linkedin.post_service.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
  @Query(value = "SELECT * FROM t_linkedin_posts WHERE user_id = ?1", nativeQuery = true)
  List<Post> findPostsByUserId(Long userId); // Find posts by user ID
}
