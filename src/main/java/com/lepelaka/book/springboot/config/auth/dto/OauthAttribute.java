package com.lepelaka.book.springboot.config.auth.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class OauthAttribute {
  private Map<String, Object> attributes;
  private String nameAttributekey;
  private String name;
  private String email;
  private String picture;

}
