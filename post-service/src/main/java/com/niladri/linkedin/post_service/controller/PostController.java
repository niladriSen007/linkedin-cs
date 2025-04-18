package com.niladri.linkedin.post_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niladri.linkedin.post_service.dto.PostDto;
import com.niladri.linkedin.post_service.dto.PostRequestDto;
import com.niladri.linkedin.post_service.service.IPostService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class PostController {

  private final IPostService postService;

  @PostMapping
  public ResponseEntity<PostDto> createPost(@RequestBody PostRequestDto postRequestDto,HttpServletRequest request) {
    PostDto postDto = postService.createPost(postRequestDto.getContent(), 1L);
    return ResponseEntity.ok(postDto);
  }

  @GetMapping
  public ResponseEntity<List<PostDto>> getAllPosts(HttpServletRequest request) {
    List<PostDto> postDtos = postService.getAllPosts();
    return ResponseEntity.ok(postDtos);
  }

  @GetMapping("/{postId}")
  public ResponseEntity<PostDto> getPostById(@PathVariable Long postId, HttpServletRequest request) {
    PostDto postDto = postService.getPostById(postId);
    return ResponseEntity.ok(postDto);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<PostDto>> getPostsByUserId(@PathVariable Long userId, HttpServletRequest request) {
    List<PostDto> postDtos = postService.getPostsByUserId(userId);
    return ResponseEntity.ok(postDtos);
  }
}
