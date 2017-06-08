package com.jmr.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

/**
 * 账号登录成功监听器
 * 修改
 *
 * Created by youtao.wan on 2017/6/8.
 */
public class LoginSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent>{

    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent){

    }
}
