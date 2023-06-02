package com.lepelaka.book.springboot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lepelaka.book.springboot.domain.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(callSuper = true)
@Entity(name = "posts")
public class PostEntity extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 500, nullable = false)
  private String title;
  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;
  private String author;

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
