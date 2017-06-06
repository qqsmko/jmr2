package com.jmr.util;

import com.jmr.model.TblAccount;
import com.jmr.model.TblAuthority;
import com.jmr.model.TblRole;

import java.util.List;

/**
 * 账户权限包装实体
 * 目前为止一个账号仅对应一个角色，一个账号对应多个角色，以后扩展，目前暂不考虑
 *
 * Created by youtao.wan on 2017/6/6.
 */
public class AccountAuthority {

    private TblAccount account;

    private TblRole role;

    private List<TblAuthority> authorities;

    public AccountAuthority() {
    }

    public AccountAuthority(TblAccount account, TblRole role, List<TblAuthority> authorities) {
        this.account = account;
        this.role = role;
        this.authorities = authorities;
    }

    public TblAccount getAccount() {
        return account;
    }

    public TblRole getRole() {
        return role;
    }

    public List<TblAuthority> getAuthorities() {
        return authorities;
    }
}
