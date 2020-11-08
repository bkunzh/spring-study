package com.bkunzh.spring.transactiondemo1.service;

import com.bkunzh.spring.transactiondemo1.dao.BkUserMapper;
import com.bkunzh.spring.transactiondemo1.model.BkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.io.IOException;

/**
 * @author bkunzh
 * @date 2020/11/8
 */
@Service
public class MyService {
    @Autowired
    BkUserMapper bkUserMapper;
    @Autowired
    PlatformTransactionManager platformTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;

    /*
    声明式事务，编程式事务测试
     */
    //@Transactional //(rollbackFor = Exception.class)
    public void testTransaction() throws Exception {
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        BkUser user1 = new BkUser();
        user1.setUsername("你好1108_4");
        System.out.println(bkUserMapper.insertOne(user1));
        //System.out.println(1 / 0);
        if (true) {
            platformTransactionManager.rollback(transactionStatus);
            throw new IOException();
        } else {
            platformTransactionManager.commit(transactionStatus);
        }
        System.out.println(bkUserMapper.insertOne(user1));
    }
}
