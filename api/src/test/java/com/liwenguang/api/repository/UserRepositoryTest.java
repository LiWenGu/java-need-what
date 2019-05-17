package com.liwenguang.api.repository;

import com.liwenguang.api.DemoApplicationTests;
import com.liwenguang.api.dao.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @Author liwenguang
 * @Date 2019-05-18 01:08
 * @Description
 */
@Slf4j
public class UserRepositoryTest extends DemoApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest() throws Exception {
        User user = new User();
        user.setName("郑龙飞");
        user.setUrl("http://merryyou.cn");
        User result = userRepository.save(user);
        log.info(result.toString());
        Assert.assertNotNull(user.getId());
        while (true) {

        }
    }

    @Test
    public void findOneTest() throws Exception{
        Optional<User> user = userRepository.findById(1L);
        log.info(user.toString());
        Assert.assertNotNull(user);
        Assert.assertTrue(1l==user.get().getId());
    }
}