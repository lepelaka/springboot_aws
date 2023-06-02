package com.lepelaka.book.springboot.domain.reply;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lepelaka.book.springboot.domain.board.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@AllArgsConstructor
@Builder
@Entity(name = "tbl_reply")
public class ReplyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long rno;
  private String replyer;
  private String reply;

  // private Long bno;
  @ManyToOne
  @JoinColumn(name = "bno")
  private BoardEntity board;
}
