package com.lepelaka.book.springboot.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lepelaka.book.springboot.service.PostService;
import com.lepelaka.book.springboot.web.dto.PostResponseDto;
import com.lepelaka.book.springboot.web.dto.PostSaveRequestDto;
import com.lepelaka.book.springboot.web.dto.PostUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostApiController {
  private final PostService postService;

  @PostMapping("/api/v1/post")
  public Long save(@RequestBody PostSaveRequestDto postSaveRequestDto) {
    return postService.save(postSaveRequestDto);
  }

  @PutMapping("/api/v1/post/{id}")
  public Long update(@RequestBody PostUpdateRequestDto postUpdateRequestDto, @PathVariable Long id) {
    return postService.update(id, postUpdateRequestDto);
  }

  @DeleteMapping("/api/v1/post/{id}")
  public Long delete(@PathVariable Long id) {
    postService.delete(id);
    return id;
  }

  @GetMapping("/api/v1/post/{id}")
  public PostResponseDto findById(@PathVariable Long id) {
    return postService.findById(id);
  }

}
