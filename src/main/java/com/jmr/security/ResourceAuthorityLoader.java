package com.jmr.security;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 加载所有资源及其访问该资源所需要的权限
 *
 * Created by youtao.wan on 2017/6/6.
 */
@Component
public class ResourceAuthorityLoader implements FilterInvocationSecurityMetadataSource{

    @Autowired
    private ResourceAuthorityCache cache;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        String url = ((FilterInvocation) o).getRequestUrl();
        int index = url.indexOf("?");
        if (index != -1){
            url = url.substring(0, index);
        }
        return cache.getIfPresent(url);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Map<String, Collection<ConfigAttribute>> map = cache.asMap();

        Set<ConfigAttribute> set = Sets.newHashSet();
        for (Collection<ConfigAttribute> configAttributes : map.values()){
            set.addAll(configAttributes);
        }
        return set;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
