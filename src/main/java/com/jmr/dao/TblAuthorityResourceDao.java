package com.jmr.dao;

import com.jmr.model.TblAuthorityResource;

import java.util.List;

/**
 * Created by youtao.wan on 2017/6/6.
 */
public interface TblAuthorityResourceDao {

    List<TblAuthorityResource> selectByAuthorityId(String authorityId);

    List<TblAuthorityResource> selectByResourceId(String resourceId);
}
