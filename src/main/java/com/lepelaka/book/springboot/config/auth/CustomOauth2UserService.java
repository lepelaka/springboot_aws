package com.lepelaka.book.springboot.config.auth;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.lepelaka.book.springboot.domain.user.UserEntity;

public class CustomOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    throw new UnsupportedOperationException("Unimplemented method 'loadUser'");
  }

  // private UserEntity saveOrUpdate(Oauth)
}
