package com.lepelaka.book.springboot.web;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lepelaka.book.springboot.domain.posts.PostEntity;
import com.lepelaka.book.springboot.domain.posts.PostRepository;
import com.lepelaka.book.springboot.web.dto.PostSaveRequestDto;
import com.lepelaka.book.springboot.web.dto.PostUpdateRequestDto;

import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Test
  public void post_등록() throws Exception {
    // given
    String title = "title";
    String content = "content";
    PostSaveRequestDto postSaveRequestDto = PostSaveRequestDto.builder().title(title).content(content).author("작성자")
        .build();

    String url = "http://localhost:" + port + "/api/v1/post";

    // when
    ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, postSaveRequestDto, Long.class);

    // then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isGreaterThan(0L);
    List<PostEntity> all = postRepository.findAll();

    assertThat(all.get(0).getTitle()).isEqualTo(title);
    assertThat(all.get(0).getContent()).isEqualTo(content);

  }

  @Test
  public void post_수정한다() {
    PostEntity savedPost = postRepository
        .save(PostEntity.builder().title("title").content("content").author("author").build());
    Long updateId = savedPost.getId();
    String expectedTitle = "title2";
    String expectedContent = "content2";

    PostUpdateRequestDto requestDto = PostUpdateRequestDto.builder().title(expectedTitle).content(expectedContent)
        .build();

    String url = "http://localhost:" + port + "/api/v1/post/" + updateId;
    log.info("url :: {}", url);
    HttpEntity<PostUpdateRequestDto> requestEntity = new HttpEntity<PostUpdateRequestDto>(requestDto);

    // when
    ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

    // then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isGreaterThan(0L);
    List<PostEntity> all = postRepository.findAll();
    assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
    assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    log.info("all : {}", all);
  }
}
