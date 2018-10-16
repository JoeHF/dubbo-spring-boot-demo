package com.joe.provider.bean;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "server")
public class Server {
  public String name;
  public List<String> addresses;
}
