package com.lepelaka.book.springboot.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lepelaka.book.springboot.domain.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "tbl_member")
@Builder
@AllArgsConstructor
public class UserEntity extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  private String picture;

  public UserEntity update(String name, String picture) {
    this.name = name;
    this.picture = picture;
    return this;
  }

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  public String getRoleKey() {
    return role.getKey();
  }
}
