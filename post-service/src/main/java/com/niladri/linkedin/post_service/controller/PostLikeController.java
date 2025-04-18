package com.niladri.linkedin.post_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niladri.linkedin.post_service.dto.LikePostRequestDto;
import com.niladri.linkedin.post_service.service.IPostLikeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/likes")
public class PostLikeController {
  private final IPostLikeService postLikeService;

  @PostMapping
  public ResponseEntity<String> likePost(@RequestBody LikePostRequestDto likePostRequestDto,
      HttpServletRequest request) {
    boolean postLiked = postLikeService.likePost(likePostRequestDto);
    return ResponseEntity.ok(
        postLiked ? "Post " + likePostRequestDto.getPostExpression() + " successfully"
            : "Post un" + likePostRequestDto.getPostExpression() + " successfully");
  }
}
