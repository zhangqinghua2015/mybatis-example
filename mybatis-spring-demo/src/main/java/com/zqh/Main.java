package com.zqh;

import com.zqh.bo.Test;
import com.zqh.dao.TestDao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.util.List;

/**
 * @discription:
 * @date: 2019/02/14 上午11:30
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
        context.refresh();

//        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
//        final TestDao testDao = sqlSessionFactory.openSession().getMapper(TestDao.class);
        final TestDao testDao = context.getBean(TestDao.class);

        /*SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        final TestDao testDao1 = sqlSessionFactory.openSession().getMapper(TestDao.class);*/

        TransactionTemplate transactionTemplate = (TransactionTemplate) context.getBean("nestedTransactionTemplate");
        transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                Test newTest = new Test();
                newTest.setRiskType(-1);
                testDao.insertTest(newTest);

                status.setRollbackOnly();
                return 1;
            }
        });

        /*List<Test> tests = testDao.getTests();
        for (Test test : tests) {
            System.out.println(test);
        }*/
    }

}
