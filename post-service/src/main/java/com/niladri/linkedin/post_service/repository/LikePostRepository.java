package com.niladri.linkedin.post_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.niladri.linkedin.post_service.entity.PostLike;

import jakarta.transaction.Transactional;

@Repository
public interface LikePostRepository extends JpaRepository<PostLike, Long> {

    @Query(value = "SELECT * FROM t_linkedin_post_likes WHERE post_id = ?1 AND user_id = ?2", nativeQuery = true)
    PostLike existsByPostIdAndUserId(Long postId, Long userId);


    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM t_linkedin_post_likes WHERE post_id = ?1 AND user_id = ?2", nativeQuery = true)
    void deleteByPostIdAndUserId(Long postId, Long userId);

}
