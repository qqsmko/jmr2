package com.jmr.security;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.jmr.model.TblAccount;
import com.jmr.model.TblAuthority;
import com.jmr.util.AccountAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 账号信息的定义与验证
 *
 * Created by youtao.wan on 2017/6/6.
 */
@Service
public class AccountSecuritySevice implements UserDetailsService{

    @Autowired
    private AccountAuthorityCache cache;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Preconditions.checkArgument(Strings.isNullOrEmpty(userName), "登录账号名为空");

        AccountAuthority accountAuthority = cache.getIfPresent(userName);
        if (accountAuthority == null){
            throw new UsernameNotFoundException(userName + "不存在");
        }

        List<TblAuthority> tblAuthorityList = accountAuthority.getAuthorities();
        List<GrantedAuthority> authorities = Lists.newArrayListWithExpectedSize(tblAuthorityList.size());
        for (TblAuthority it: tblAuthorityList){
            authorities.add(new SimpleGrantedAuthority(it.getAuthorityName()));
        }

        TblAccount account = accountAuthority.getAccount();

        // 是否过期
        boolean isExpired = account.isExpired() || new Date().compareTo(account.getDeadLine()) == -1;

        UserDetails userDetails = new User(account.getUserName(),
                account.getPassword(),
                account.isEnable(),
                isExpired,
                true,
                account.isLocked(),
                authorities);
        return userDetails;
    }
}
