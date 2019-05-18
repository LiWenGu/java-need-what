package com.liwenguang.api.repository;

import com.liwenguang.api.DemoApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author liwenguang
 * @Date 2019-05-18 01:08
 * @Description
 */
@Slf4j
public class UserRepositoryTest extends DemoApplicationTests {
    @Autowired
    private JobDescRepository userRepository;

    @Test
    public void saveTest() throws Exception {

    }

    @Test
    public void findOneTest() throws Exception{

    }
}