package com.jmr.security;

import com.google.common.base.Supplier;
import com.google.common.cache.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jmr.dao.*;
import com.jmr.model.*;
import com.jmr.util.AccountAuthorities;
import com.jmr.util.RoleAuthorities;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 账户权限缓存
 *
 * Created by youtao.wan on 2017/6/6.
 */
@Component
public class AccountAuthorityCache extends ForwardingCache<String, AccountAuthorities>{

    @Resource
    private TblAccountDao accountDao;

    @Resource
    private TblRoleDao roleDao;

    @Resource
    private TblAuthorityDao authorityDao;

    @Resource
    private TblUserRoleDao userRoleDao;

    @Resource
    private TblRoleAuthorityDao roleAuthorityDao;

    private Cache<String, AccountAuthorities> singleCache;

    public AccountAuthorityCache() {
        singleCache = new SingleCache().get();
    }

    public AccountAuthorityCache(Cache<String, AccountAuthorities> singleCache) {
        this.singleCache = singleCache;
    }

    @Override
    protected Cache<String, AccountAuthorities> delegate() {
        return singleCache;
    }

    /**
     * 从db中加载用户的权限信息
     *
     * @param userName
     * @return
     */
    private AccountAuthorities loadAccountAuthorities(String userName){
        TblAccount account = accountDao.selectByUserName(userName);
        if (account == null || !account.isEnable()){
            // TODO add log
            return null;
        }

        List<TblUserRole> userRoleList = userRoleDao.selectByUserId(account.getUserId());
        if (CollectionUtils.isEmpty(userRoleList)){
            return null;
        }

        List<RoleAuthorities> roleAuthoritiesList = Lists.newArrayListWithExpectedSize(userRoleList.size());
        for (TblUserRole it: userRoleList){
            RoleAuthorities roleAuthorities = loadRoleAuthorities(it.getRoleId());
            if (roleAuthorities != null){
                roleAuthoritiesList.add(roleAuthorities);
            }
        }

        return new AccountAuthorities(account, roleAuthoritiesList);
    }

    /**
     * 从db中加载角色的权限信息
     *
     * @param roleId
     * @return
     */
    private RoleAuthorities loadRoleAuthorities(String roleId){
        TblRole role = roleDao.selectByRoleId(roleId);
        if (role == null || !role.isEnable()){
            return null;
        }

        List<TblRoleAuthority> roleAuthorityList = roleAuthorityDao.selectByRoleId(roleId);
        if (CollectionUtils.isEmpty(roleAuthorityList)){
            return new RoleAuthorities(role, ImmutableList.<TblAuthority>of());
        }

        List<TblAuthority> authorityList = Lists.newArrayListWithExpectedSize(roleAuthorityList.size());
        for (TblRoleAuthority it: roleAuthorityList){
            TblAuthority authority = authorityDao.selectByAuthorityId(it.getAuthorityId());
            if (authority != null && authority.isEnable()){
                authorityList.add(authority);
            }
        }
        return new RoleAuthorities(role, authorityList);
    }

    class SingleCache implements Supplier<Cache<String, AccountAuthorities>>{

        private LoadingCache<String, AccountAuthorities> cache = CacheBuilder.newBuilder()
                .maximumSize(100).expireAfterAccess(30, TimeUnit.MINUTES)
                .build(new CacheLoader<String, AccountAuthorities>() {
                    @Override
                    public AccountAuthorities load(String s) throws Exception {
                        return loadAccountAuthorities(s);
                    }
                });

        @Override
        public Cache<String, AccountAuthorities> get() {
            return cache;
        }
    }
}
