package com.niladri.linkedin.post_service.service;

import org.springframework.stereotype.Service;

import com.niladri.linkedin.post_service.dto.LikePostRequestDto;
import com.niladri.linkedin.post_service.entity.Post;
import com.niladri.linkedin.post_service.entity.PostLike;
import com.niladri.linkedin.post_service.exceptions.UnableToUnlike;
import com.niladri.linkedin.post_service.repository.LikePostRepository;
import com.niladri.linkedin.post_service.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class PostLikeServiceImpl implements IPostLikeService {

  private final PostRepository postRepository;
  private final LikePostRepository likePostRepository;

  @Override
  public boolean likePost(LikePostRequestDto likePostRequestDto) {
    Long postId = likePostRequestDto.getPostId();
    Long userId = likePostRequestDto.getUserId();
    String expression = likePostRequestDto.getPostExpression();
    log.info("User {} {} post {}", userId,expression, postId);
    postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
    PostLike alreadyExixts = likePostRepository.existsByPostIdAndUserId(postId, userId);
    if (alreadyExixts != null) {
      log.info("User {} already {} post {}", userId,expression, postId);
      try {
        likePostRepository.deleteByPostIdAndUserId(postId, userId);
        log.info("User {} un{} post {}", userId,expression, postId);
        return false;
      } catch (Exception e) {
        log.error("Error while unliking the post", e.getCause());
        throw new UnableToUnlike("Error while unliking the post", e.getCause());
      } finally {
        log.error("Post un{} successfully by user {}",expression, userId);
      }
    }
    PostLike postLike = new PostLike();
    postLike.setPostId(postId);
    postLike.setUserId(userId);
    postLike.setPostExpression(expression);
    likePostRepository.save(postLike);
    log.info("User {} liked post {}", userId, postId);
    return true;
  }

  @Override
  public void unlikePost(Long postId, Long userId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'unlikePost'");
  }

}
