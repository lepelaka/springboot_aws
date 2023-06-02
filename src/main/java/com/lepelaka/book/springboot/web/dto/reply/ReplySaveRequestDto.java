package com.lepelaka.book.springboot.web.dto.reply;

import com.lepelaka.book.springboot.domain.board.BoardEntity;
import com.lepelaka.book.springboot.domain.reply.ReplyEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplySaveRequestDto {
  private String replyer;
  private String reply;
  private Long bno;

  public ReplyEntity toEntity() {
    return ReplyEntity.builder().reply(reply).replyer(replyer).board(BoardEntity.builder().bno(bno).build()).build();
  }
}
