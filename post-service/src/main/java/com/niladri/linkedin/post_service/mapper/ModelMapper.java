package com.niladri.linkedin.post_service.mapper;

import com.niladri.linkedin.post_service.dto.PostDto;
import com.niladri.linkedin.post_service.entity.Post;

public class ModelMapper {

  private ModelMapper() {}
  public static PostDto mapToPostDto(Post post) {
    PostDto postDto = new PostDto();
    postDto.setId(post.getId());
    postDto.setUserId(post.getUserId());
    postDto.setContent(post.getContent());
    postDto.setCreatedAt(post.getCreatedAt());
    return postDto;
  }

  public static Post mapToPost(PostDto postDto) {
    Post post = new Post();
    post.setId(postDto.getId());
    post.setUserId(postDto.getUserId());
    post.setContent(postDto.getContent());
    post.setCreatedAt(postDto.getCreatedAt());
    return post;
  }
}
