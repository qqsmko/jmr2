package com.jmr.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 账号登录成功监听器
 * 修改登录时间,登录Ip
 *
 * Created by youtao.wan on 2017/6/8.
 */
@Component
public class LoginSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent>{

    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent){
        // 此处的类型转化需要看源码
        Authentication authentication = authenticationSuccessEvent.getAuthentication();
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails)token.getDetails();
        String loginIp = webAuthenticationDetails.getRemoteAddress();

        Date loginTime = new Date();
        String userName = authentication.getName();

        //TODO 更新账号的登录时间和登录Ip
    }
}
