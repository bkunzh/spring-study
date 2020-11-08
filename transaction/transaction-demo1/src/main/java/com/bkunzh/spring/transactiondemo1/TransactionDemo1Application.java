package com.bkunzh.spring.transactiondemo1;

import com.bkunzh.spring.transactiondemo1.dao.BkUserMapper;
import com.bkunzh.spring.transactiondemo1.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TransactionDemo1Application {

    static final Logger log = LoggerFactory.getLogger(TransactionDemo1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(TransactionDemo1Application.class, args);
    }

    @PostConstruct
    public void doSome() {
        //transactionDemo1Application.testMybatis();
        this.testMybatis();
    }

    @Autowired
    TransactionDemo1Application transactionDemo1Application;

    @Autowired
    BkUserMapper bkUserMapper;
    @Autowired
    MyService myService;

    void testMybatis() {
        try {
            myService.testTransaction();
        } catch (Exception e) {
            log.error("testTransaction error ", e);
        }
        System.out.println(bkUserMapper.findAll().size());

    }

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        // >>>>>>>>>> platformTransactionManager org.springframework.jdbc.datasource.DataSourceTransactionManager
        System.out.println(">>>>>>>>>> platformTransactionManager " + platformTransactionManager.getClass().getName());
        return null;
    }

}
