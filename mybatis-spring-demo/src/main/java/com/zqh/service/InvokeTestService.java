package com.zqh.service;

import com.zqh.bo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zhangqinghua
 * @email: zidian.zqh@raycloud.com
 * @date: 2021/1/22 5:55 下午
 */
@Service
public class InvokeTestService {

    @Autowired
    private TestService testService;


//    @Transactional
    public void invoke() {
        Test test = new Test();
        test.setRiskType(2);
        testService.insertTest(test);

        testService.updTest();
    }

}
