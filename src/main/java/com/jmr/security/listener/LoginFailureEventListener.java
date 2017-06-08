package com.jmr.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

/**
 * 账号登录失败事件监听
 * 如果连续三次密码输入失败，直接锁定账号
 *
 * Created by youtao.wan on 2017/6/8.
 */
@Component
public class LoginFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {
        String userName = authenticationFailureBadCredentialsEvent.getAuthentication().getName();

        //TODO 是否需要锁死账户
    }
}
