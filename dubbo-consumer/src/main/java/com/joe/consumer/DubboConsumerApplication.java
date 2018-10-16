package com.joe.consumer;

import com.joe.consumer.bean.MyBean;
import com.joe.consumer.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication(scanBasePackages = "com.joe.consumer")
public class DubboConsumerApplication {

    @Bean
    public Runnable createRunnable(){
        return () -> System.out.println("spring boot is running");
    }

    @Bean
    public MyBean getMyBean() {
        return new MyBean();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DubboConsumerApplication.class,args);

        context.getBean(Runnable.class).run();
        System.out.println(context.getBean(User.class));
        Map map = (Map) context.getBean("createMap");
        int age = (int) map.get("age");
        System.out.println("age=="+age);

    }
}
