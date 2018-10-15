package com.joe.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.joe.api.ICityService;
import com.joe.api.model.City;
import com.joe.consumer.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboConsumerController {

    @Autowired
    private VideoService videoService;

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}")
    private ICityService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        City city = demoService.findCityByName(name);
        return city.getCityName();
    }

    @RequestMapping("/video")
    public String videoName(){
        return videoService.getVideoName();
    }
}

