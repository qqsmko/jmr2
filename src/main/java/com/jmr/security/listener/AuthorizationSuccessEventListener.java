package com.jmr.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.access.event.AuthorizedEvent;

/**
 * 用户访问资源授权成功事件监听器
 * 可在此处添加操作日志
 *
 * Created by youtao.wan on 2017/6/8.
 */
public class AuthorizationSuccessEventListener implements ApplicationListener<AuthorizedEvent>{

    @Override
    public void onApplicationEvent(AuthorizedEvent authorizedEvent) {

    }
}
