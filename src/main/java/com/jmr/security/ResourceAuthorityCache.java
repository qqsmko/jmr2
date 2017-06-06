package com.jmr.security;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.cache.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.jmr.dao.TblAccessResourceDao;
import com.jmr.dao.TblAuthorityDao;
import com.jmr.dao.TblAuthorityResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by youtao.wan on 2017/6/6.
 */
@Component
public class ResourceAuthorityCache extends ForwardingCache<String, Collection<ConfigAttribute>>{

    @Autowired
    private TblAuthorityDao authorityDao;

    @Autowired
    private TblAccessResourceDao accessResourceDao;

    @Autowired
    private TblAuthorityResourceDao authorityResourceDao;

    private Cache<String, Collection<ConfigAttribute>> singleCache;


    public ResourceAuthorityCache() {
        singleCache = new SingleCache().get();
    }

    public ResourceAuthorityCache(Cache<String, Collection<ConfigAttribute>> singleCache) {
        this.singleCache = singleCache;
    }

    @Override
    protected Cache<String, Collection<ConfigAttribute>> delegate() {
        return singleCache;
    }

    /**
     * 有点问题，想想
     *
     * @param key
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getIfPresent(Object key) {
        String url = (String) key;

        Set<ConfigAttribute> set = Sets.newHashSet();

        Map<String, Collection<ConfigAttribute>> map = delegate().asMap();
        for (Map.Entry<String, Collection<ConfigAttribute>> entry: map.entrySet()){
            if (isMatch(url, entry.getKey())){
                set.addAll(entry.getValue());
            }
        }
        return set;
    }

    /**
     * 匹配两个URl是否相同
     * @param s1
     * @param s2
     * @return
     */
    private boolean isMatch(String s1, String s2){
        return false;
    }

    private List<ConfigAttribute> loadFromDatabase(String url){
        Preconditions.checkArgument(Strings.isNullOrEmpty(url), "请求资源为空");


        return ImmutableList.of();
    }

    class SingleCache implements Supplier<Cache<String, Collection<ConfigAttribute>>>{

        private LoadingCache<String, Collection<ConfigAttribute>> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(30, TimeUnit.DAYS)
                .build(new CacheLoader<String, Collection<ConfigAttribute>>() {
                    @Override
                    public Collection<ConfigAttribute> load(String s) throws Exception {
                        return loadFromDatabase(s);
                    }
                });

        @Override
        public Cache<String, Collection<ConfigAttribute>> get() {
            return cache;
        }
    }
}
