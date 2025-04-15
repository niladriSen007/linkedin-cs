package com.niladri.linkedin.post_service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostDto {
  private Long id;
  private Long userId;
  private String content;
  private LocalDateTime createdAt;
}
