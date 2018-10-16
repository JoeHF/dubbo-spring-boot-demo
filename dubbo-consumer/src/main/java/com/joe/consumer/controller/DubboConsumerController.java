package com.joe.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.joe.api.ICityService;
import com.joe.api.model.City;
import com.joe.consumer.bean.MyBean;
import com.joe.consumer.configuration.BasicConfiguration;
import com.joe.consumer.service.VideoService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class DubboConsumerController {

  @Autowired private VideoService videoService;

  @Autowired private MyBean myBean;

  @Autowired private BasicConfiguration configuration;

  @Value("${welcome.message}")
  private String welcomeMessage;

  @Reference(version = "1.0.0", application = "${dubbo.application.id}")
  private ICityService demoService;

  @RequestMapping("/sayHello")
  public String sayHello(@RequestParam String name) {
    City city = demoService.findCityByName(name);
    return city.getCityName();
  }

  @RequestMapping("/video")
  public String videoName() {
    return videoService.getVideoName();
  }

  @GetMapping("/welcome")
  public String retrieveWelcomeMessage() {
    // Complex Method
    return welcomeMessage;
  }

  @RequestMapping("/dynamic-configuration")
  public Map dynamicConfiguration() {
    // Not the best practice to use a map to store differnt types!
    Map map = new HashMap();
    map.put("message", configuration.getMessage());
    map.put("number", configuration.getNumber());
    map.put("key", configuration.isValue());
    return map;
  }

  @RequestMapping("/mybean")
  @ResponseBody
  public String theHandler() {
    return myBean.getMessage();
  }
}
