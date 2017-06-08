package com.jmr.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.event.AuthorizedEvent;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 用户访问资源授权成功事件监听器
 * 可在此处添加操作日志
 *
 * Created by youtao.wan on 2017/6/8.
 */
@Component
public class AuthorizationSuccessEventListener implements ApplicationListener<AuthorizedEvent>{

    @Override
    public void onApplicationEvent(AuthorizedEvent authorizedEvent) {
        FilterInvocation invocation = (FilterInvocation) authorizedEvent.getSource();
        String url = invocation.getRequestUrl();
        String userName = authorizedEvent.getAuthentication().getName();
        String authorityName = "";
        Collection<ConfigAttribute> collection = authorizedEvent.getConfigAttributes();
        if (!CollectionUtils.isEmpty(collection)){
            for (ConfigAttribute it: collection){
                authorityName = it.getAttribute();
            }
        }

        // TODO {userName} 对 {url} 执行了 {authorityName}操作
    }
}
