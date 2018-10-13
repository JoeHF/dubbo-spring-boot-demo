package com.joe.provider.bean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ServerTest {

    @Autowired
    private Server server;

    @Test
    public void test() {
        Assert.assertEquals("app", server.getName());
        Assert.assertEquals(2, server.getAddresses().size());
        System.out.println("Server display name:" + server.getName());
        System.out.println("Server address:" + server.getAddresses());
    }
}
