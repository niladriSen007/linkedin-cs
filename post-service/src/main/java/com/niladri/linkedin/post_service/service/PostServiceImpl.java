package com.niladri.linkedin.post_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.niladri.linkedin.post_service.dto.PostDto;
import com.niladri.linkedin.post_service.entity.Post;
import com.niladri.linkedin.post_service.exceptions.ProductNotFound;
import com.niladri.linkedin.post_service.mapper.ModelMapper;
import com.niladri.linkedin.post_service.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements IPostService {

  private final PostRepository postRepository;

  @Override
  public PostDto createPost(String content, Long userId) {
    Post post = new Post();
    post.setContent(content);
    post.setUserId(userId);
    post.setCreatedAt(LocalDateTime.now());
    postRepository.save(post);
    return ModelMapper.mapToPostDto(post);
  }

  @Override
  public List<PostDto> getAllPosts() {
    List<Post> posts = postRepository.findAll();
    return posts.stream()
        .map(ModelMapper::mapToPostDto)
        .toList();
  }

  @Override
  public PostDto getPostById(Long postId) {
    Optional<Post> postOptional = postRepository.findById(postId);
    if (postOptional.isPresent()) {
      Post post = postOptional.get();
      return ModelMapper.mapToPostDto(post);
    } else {
      log.error("Post with ID {} not found", postId);
      throw new ProductNotFound("Post not found");
    }
  }

  @Override
  public List<PostDto> getPostsByUserId(Long userId) {
    List<Post> posts = postRepository.findPostsByUserId(userId);
    return posts.stream()
        .map(ModelMapper::mapToPostDto)
        .toList();
  }

}
