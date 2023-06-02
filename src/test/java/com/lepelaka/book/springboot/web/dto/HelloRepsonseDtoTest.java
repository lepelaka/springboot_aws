package com.lepelaka.book.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloRepsonseDtoTest {
  @Test
  public void 롬복_테스트() {
    // given
    String name = "test";
    int amount = 1000;

    // when
    HelloResponseDto dto = new HelloResponseDto(name, amount);
    // new HelloResponseDto();

    // then
    Assertions.assertThat(dto.getName()).isEqualTo(name);
    Assertions.assertThat(dto.getAmount()).isEqualTo(amount);

  }
}
