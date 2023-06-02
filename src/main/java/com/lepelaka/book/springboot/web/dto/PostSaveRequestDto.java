package com.lepelaka.book.springboot.web.dto;

import com.lepelaka.book.springboot.domain.posts.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostSaveRequestDto {
  private String title;
  private String content;
  private String author;

  public PostEntity toEntity() {
    return PostEntity.builder().title(title).content(content).author(author).build();
  }
}
