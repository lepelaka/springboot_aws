package com.lepelaka.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
public class HelloController {
  @GetMapping("hello")
  public String hello() {
    return "hello";
  }

  @GetMapping("myHello")
  public String hello2(String msg, Long value) {
    return "myHello";
  }
}
