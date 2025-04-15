package com.niladri.linkedin.post_service.dto;

import lombok.Data;

@Data
public class LikePostRequestDto {
  private Long postId;
  private Long userId;
  private String postExpression;
}
