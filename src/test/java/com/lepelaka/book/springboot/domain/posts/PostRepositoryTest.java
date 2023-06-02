package com.lepelaka.book.springboot.domain.posts;

import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class PostRepositoryTest {
  @Autowired
  private PostRepository repository;

  @Test
  public void baseTimeEntity_등록() {
    // LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);

    PostEntity pe = repository.save(PostEntity.builder().title("제목").content("내용").author("작성자").build());
    log.info("post entity : {}", pe);
    log.info("creation time : {} ", pe.getRegDate());
    log.info("creation time : {} ", pe.getUpdateDate());

    repository.findAll().forEach(r -> {
      log.info("entity : {}", r);
      log.info("r.getCreateDate : {}", r.getRegDate());
      log.info("r.getModifiedDate : {}", r.getUpdateDate());
    });
  }

  @Test
  public void 게시글저장_불러오기() {
    // given
    String title = "테스트 게시글";
    String content = "테스트 본문";

    repository.save(PostEntity.builder().title(title).content(content).author("작성자").build());

    // when
    List<PostEntity> postList = repository.findAll();

    // then
    PostEntity post = postList.get(0);

    Assertions.assertThat(post.getTitle()).isEqualTo(title);
    Assertions.assertThat(post.getContent()).isEqualTo(content);

    log.info("{}", post);
  }
}
