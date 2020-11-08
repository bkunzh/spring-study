package com.bkunzh.spring.transactiondemo1.dao;

import com.bkunzh.spring.transactiondemo1.model.BkUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author bkunzh
 * @date 2020/11/8
 */
@Mapper
public interface BkUserMapper {


    BkUser getById(Integer id);

    int insertOne(BkUser bkUser);

    List<BkUser> findAll();
}
