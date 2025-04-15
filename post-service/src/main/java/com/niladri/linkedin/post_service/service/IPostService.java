package com.niladri.linkedin.post_service.service;

import java.util.List;

import com.niladri.linkedin.post_service.dto.PostDto;

public interface IPostService {
  PostDto createPost(String content, Long userId); // Create a new post
  List<PostDto> getAllPosts(); // Get all posts
  PostDto getPostById(Long postId); // Get a post by its ID
  List<PostDto> getPostsByUserId(Long userId); // Get posts by user ID
}
