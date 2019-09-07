package com.aleshka.demo;

import com.aleshka.demo.entity.User;
import com.aleshka.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpTestApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        User user=new User("test", 1234);
        userRepository.save(user);
        Assert.isTrue(userRepository.findAll().contains(user),"if contains its ok");

    }

}
