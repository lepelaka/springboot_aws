package com.lepelaka.book.springboot.web.dto;

import com.lepelaka.book.springboot.domain.posts.PostEntity;

import lombok.Getter;

@Getter
public class PostResponseDto {
  private Long id;
  private String title;
  private String content;
  private String author;

  public PostResponseDto(PostEntity postEntity) {
    this.id = postEntity.getId();
    this.title = postEntity.getTitle();
    this.content = postEntity.getContent();
    this.author = postEntity.getAuthor();
  }
}
