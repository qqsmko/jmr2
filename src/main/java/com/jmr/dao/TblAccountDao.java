package com.jmr.dao;

import com.jmr.model.TblAccount;

/**
 * Created by youtao.wan on 2017/6/6.
 */
public interface TblAccountDao {

    /**
     * 根据用户名加载账号信息
     * @param userName
     * @return
     */
    TblAccount selectByUserName(String userName);
}
