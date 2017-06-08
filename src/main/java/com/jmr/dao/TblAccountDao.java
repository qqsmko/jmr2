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

    /**
     * 更新账号锁定状态
     *
     * @param userName
     * @param isLocked
     * @return
     */
    int updateLockedStatus(String userName, boolean isLocked);

    /**
     * 更新账号可用状态
     *
     * @param userName
     * @param enable
     * @return
     */
    int updateEnableStatus(String userName, boolean enable);

    /**
     * 更新账号过期状态
     *
     * @param userName
     * @param isExpired
     * @return
     */
    int updateExpiredStatus(String userName, boolean isExpired);
}
