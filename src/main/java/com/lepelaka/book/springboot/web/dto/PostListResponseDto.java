package com.lepelaka.book.springboot.web.dto;

import java.time.LocalDateTime;

import com.lepelaka.book.springboot.domain.posts.PostEntity;

import lombok.Getter;

@Getter
public class PostListResponseDto {
  private Long id;
  private String title;
  private String author;
  private LocalDateTime updateDate;

  public PostListResponseDto(PostEntity entity) {
    id = entity.getId();
    title = entity.getTitle();
    author = entity.getAuthor();
    updateDate = entity.getUpdateDate();
  }
}
