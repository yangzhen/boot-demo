package com.uc.server.server;

import com.alibaba.fastjson.JSON;
import com.uc.server.Application;
import com.uc.server.domain.dao.UserInfoDao;
import com.uc.server.domain.entry.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@EnableTransactionManagement(proxyTargetClass = true)
public class AppTest {

    Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void test() {
        UserInfo userInfo = userInfoDao.findByUserId(3);
        System.out.println(JSON.toJSONString(userInfo));
    }


}
