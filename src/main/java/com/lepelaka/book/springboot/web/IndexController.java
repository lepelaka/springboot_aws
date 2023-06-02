package com.lepelaka.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lepelaka.book.springboot.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
  private final PostService postService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("posts", postService.findAllDesc());
    return "index";
  }

  @GetMapping("/post/update/{id}")
  public String index(@PathVariable Long id, Model model) {
    model.addAttribute("post", postService.findById(id));
    return "post-update";
  }

  @GetMapping("/post/save")
  public String postSave() {
    return "post-save";
  }
}
