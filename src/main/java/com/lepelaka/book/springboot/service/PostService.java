package com.lepelaka.book.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lepelaka.book.springboot.domain.posts.PostEntity;
import com.lepelaka.book.springboot.domain.posts.PostRepository;
import com.lepelaka.book.springboot.web.dto.PostListResponseDto;
import com.lepelaka.book.springboot.web.dto.PostResponseDto;
import com.lepelaka.book.springboot.web.dto.PostSaveRequestDto;
import com.lepelaka.book.springboot.web.dto.PostUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
  private final PostRepository postRepository;

  @Transactional
  public Long save(PostSaveRequestDto dto) {
    return postRepository.save(dto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostUpdateRequestDto postUpdateRequestDto) {
    PostEntity entity = postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    entity.update(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContent());
    return id;
  }

  public PostResponseDto findById(Long id) {
    PostEntity entity = postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    return new PostResponseDto(entity);
  }

  @Transactional
  public List<PostListResponseDto> findAllDesc() {
    return postRepository.findAll(Sort.by(Direction.DESC, "id")).stream().map(PostListResponseDto::new)
        .collect(Collectors.toList());
  }

  @Transactional
  public void delete(Long id) {
    postRepository
        .delete(postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)));
  }
}
