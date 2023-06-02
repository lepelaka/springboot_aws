package com.lepelaka.book.springboot.domain.reply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.lepelaka.book.springboot.domain.board.BoardEntity;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ReplyRepositoryTest {
  @Autowired
  private ReplyRepository replyRepository;

  @Test
  public void test_댓글_가져오기() {
    replyRepository.findAll(Sort.by(Direction.DESC, "rno")).forEach(boardRepository -> log.info("{}", boardRepository));
  }

  @Test
  public void test_댓글_작성하기() {

    ReplyEntity replyEntity = ReplyEntity.builder()
        .reply("댓글 내용222")
        .replyer("댓글 작성자222")
        .board(BoardEntity.builder().bno(20L).build())
        .build();
    replyRepository.save(replyEntity);

  }
}
