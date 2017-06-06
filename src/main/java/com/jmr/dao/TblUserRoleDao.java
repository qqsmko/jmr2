package com.jmr.dao;

import com.jmr.model.TblUserRole;

import java.util.List;

/**
 * Created by youtao.wan on 2017/6/6.
 */
public interface TblUserRoleDao {

    List<TblUserRole> selectByUserId(String UserId);
}
