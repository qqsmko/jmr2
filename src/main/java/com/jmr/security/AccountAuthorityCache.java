package com.jmr.security;

import com.google.common.base.Supplier;
import com.google.common.cache.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jmr.dao.*;
import com.jmr.model.*;
import com.jmr.util.AccountAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 账户权限缓存
 *
 * Created by youtao.wan on 2017/6/6.
 */
@Component
public class AccountAuthorityCache extends ForwardingCache<String, AccountAuthority>{

    @Autowired
    private TblAccountDao accountDao;

    @Autowired
    private TblRoleDao roleDao;

    @Autowired
    private TblAuthorityDao authorityDao;

    @Autowired
    private TblUserRoleDao userRoleDao;

    @Autowired
    private TblRoleAuthorityDao roleAuthorityDao;

    private SingleCache singleCache = new SingleCache();

    @Override
    protected Cache<String, AccountAuthority> delegate() {
        return singleCache.get();
    }

    /**
     * 从db中加载用户的账户、角色、权限信息
     *
     * @param userName
     * @return
     */
    private AccountAuthority doLoad(String userName){
        TblAccount account = accountDao.selectByUserName(userName);
        if (account == null){
            return null;
        }

        List<TblUserRole> userRoleList = userRoleDao.selectByUserId(account.getUserId());
        if (CollectionUtils.isEmpty(userRoleList)){
            return null;
        }

        TblRole role = roleDao.selectByRoleId(userRoleList.get(0).getRoleId());

        List<TblRoleAuthority> roleAuthorities = roleAuthorityDao.selectByRoleId(role.getRoleId());
        if (CollectionUtils.isEmpty(roleAuthorities)){
            return new AccountAuthority(account, role, ImmutableList.<TblAuthority>of());
        }

        List<TblAuthority> authorities = Lists.newArrayListWithExpectedSize(roleAuthorities.size());
        for (TblRoleAuthority it: roleAuthorities){
            TblAuthority authority = authorityDao.selectByAuthorityId(it.getAuthorityId());
            if (authority != null){
                authorities.add(authority);
            }
        }
        return new AccountAuthority(account, role, authorities);
    }

    class SingleCache implements Supplier<Cache<String, AccountAuthority>>{

        private LoadingCache<String, AccountAuthority> cache = CacheBuilder.newBuilder()
                .maximumSize(100).expireAfterAccess(30, TimeUnit.MINUTES)
                .build(new CacheLoader<String, AccountAuthority>() {
                    @Override
                    public AccountAuthority load(String s) throws Exception {
                        return doLoad(s);
                    }
                });

        @Override
        public Cache<String, AccountAuthority> get() {
            return cache;
        }
    }
}
