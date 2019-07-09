package com.bkunzhang.springboot.datasource;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by bkunzhang on 2019/7/9.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DataSourceTest {

    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoad() {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource);
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSourceProperties);

        //jdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<?> resultList = jdbcTemplate.queryForList("select * from user");
        System.out.println(JSON.toJSONString(resultList));
    }

}
