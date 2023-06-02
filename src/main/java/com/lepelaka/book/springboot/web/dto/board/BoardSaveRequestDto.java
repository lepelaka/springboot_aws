package com.lepelaka.book.springboot.web.dto.board;

import com.lepelaka.book.springboot.domain.board.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardSaveRequestDto {
  private String title;
  private String content;
  private String writer;

  public BoardEntity toEntity() {
    return BoardEntity.builder().title(title).content(content).writer(writer).build();
  }
}
