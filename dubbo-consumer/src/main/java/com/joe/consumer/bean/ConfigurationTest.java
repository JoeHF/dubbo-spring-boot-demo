package com.joe.consumer.bean;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ConfigurationTest {

  @Bean
  public Map createMap() {
    Map map = new HashMap();
    map.put("username", "zhihao.miao");
    map.put("age", 27);
    return map;
  }
}
