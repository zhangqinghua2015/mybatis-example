package com.zqh;

import com.zqh.bo.Test;
import com.zqh.dao.TestDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @discription:
 * @date: 2019/02/14 上午11:30
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // 初始化mybatis
        // 读取mybatis-config.xml 文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        // 创建SqlSessionFactory 类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建Session 实例
        SqlSession session = sqlSessionFactory.openSession(false);

        TestDao testDao = session.getMapper(TestDao.class);
        List<Test> tests = testDao.getTests();
        for (Test test : tests) {
            System.out.println(test);
        }
        Test newTest = new Test();
        newTest.setRiskType(-1);
        testDao.insertTest(newTest);
        tests = testDao.getTests();
        for (Test test : tests) {
            System.out.println(test);
        }
        session.close();
    }

}
