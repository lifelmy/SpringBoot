package com.example.girl.service;

import com.example.girl.domain.GirlEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 对service进行单元测试
 * 在service特定的方法上右击，选择goto  test,idea会自动生成测试方法
 * @RunWith(SpringRunner.class)  表示在测试环境中跑
 * @SpringBootTest  表示将启动整个Spring的工程
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;
    @Test
    public void findOne() throws Exception {
        GirlEntity girl=girlService.findOne(13);
        Assert.assertEquals(girl.getAge(),new Integer(14));
    }

}