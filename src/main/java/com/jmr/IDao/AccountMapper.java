package com.jmr.IDao;

import com.jmr.model.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(String account);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String account);
    
    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}