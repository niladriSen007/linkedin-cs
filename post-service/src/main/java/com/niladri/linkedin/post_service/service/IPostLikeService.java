package com.niladri.linkedin.post_service.service;

import com.niladri.linkedin.post_service.dto.LikePostRequestDto;

public interface IPostLikeService {
  boolean likePost(LikePostRequestDto likePostRequestDto);
  void unlikePost(Long postId, Long userId);
}
