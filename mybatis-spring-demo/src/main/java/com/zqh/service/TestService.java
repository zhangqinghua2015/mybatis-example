package com.zqh.service;

import com.zqh.bo.Test;
import com.zqh.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zhangqinghua
 * @email: zidian.zqh@raycloud.com
 * @date: 2021/1/22 5:51 下午
 */
@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public void insertTest(Test test) {
        testDao.insertTest(test);
    }

    @Transactional
    public void updTest() {
        testDao.updTest();
    }

}
