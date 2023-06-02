package com.lepelaka.book.springboot.domain.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardRepositoryTest {
  @Autowired
  private BoardRepository boardRepository;

  @Test
  public void test_게시글_가져오기() {
    boardRepository.findAll(Sort.by(Direction.DESC, "bno")).forEach(boardRepository -> log.info("{}", boardRepository));
  }
}
