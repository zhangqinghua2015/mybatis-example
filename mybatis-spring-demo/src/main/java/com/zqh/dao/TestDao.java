package com.zqh.dao;

import com.zqh.bo.Test;

import java.util.List;

/**
 * @discription:
 * @date: 2019/02/14 上午10:52
 */
public interface TestDao {

    List<Test> getTests();

    Integer insertTest(Test test);

}
