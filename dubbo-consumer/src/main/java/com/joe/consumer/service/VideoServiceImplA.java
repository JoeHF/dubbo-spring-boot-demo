package com.joe.consumer.service;

import org.springframework.stereotype.Service;

@Service
public class VideoServiceImplA implements VideoService {

  @Override
  public String getVideoName() {
    return "三生三世十里桃花";
  }
}
