package com.jmr.security;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 账号信息的定义与验证
 *
 * Created by youtao.wan on 2017/6/6.
 */
public class AccountSecuritySevice implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Preconditions.checkArgument(Strings.isNullOrEmpty(s), "登录账号名为空");
        return null;
    }
}
