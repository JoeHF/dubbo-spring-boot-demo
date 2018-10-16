package com.joe.consumer.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudentDao {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testHello1() {
        Student s = studentMapper.findById(1);
        System.out.println("student name:"+s.getName());//for console output
        assertNotNull(s);
    }
}