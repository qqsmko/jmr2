package com.jmr.security.listener;

import com.jmr.dao.TblAccountDao;
import com.jmr.dao.TblIndicatorStatisticsDao;
import com.jmr.model.TblIndicatorStatistics;
import com.jmr.security.AccountAuthorityCache;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 账号登录失败事件监听
 * 如果连续三次密码输入失败，直接锁定账号
 *
 * Created by youtao.wan on 2017/6/8.
 */
@Component
public class LoginFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private static final String ACCOUNT_INDICATOR = "Account";

    private static final String ACCOUNT_INDICATOR_CYCLETIME = "1d";

    private static final int ACCOUNT_LOGIN_FAIL_LIMIT = 3;

    @Resource
    private TblIndicatorStatisticsDao indicatorStatisticsDao;

    @Resource
    private TblAccountDao accountDao;

    @Resource
    private AccountAuthorityCache cache;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {
        String userName = authenticationFailureBadCredentialsEvent.getAuthentication().getName();

        TblIndicatorStatistics indicatorStatistics = indicatorStatisticsDao.selectByTypeAndName(ACCOUNT_INDICATOR, userName);
        if (indicatorStatistics == null){
            indicatorStatisticsDao.insert(null);
        }else {
            int cycleStatisticsValue = indicatorStatistics.getCycleStatisticsValue();
            if (indicatorStatistics.isCycle()){
                // 账号在一个周期内连续3次登录失败，直接锁定账号
                if (cycleStatisticsValue > ACCOUNT_LOGIN_FAIL_LIMIT){
                    lockAccount(userName);
                }
                cycleStatisticsValue += 1;
                indicatorStatisticsDao.updateCycleStatisticsValue(ACCOUNT_INDICATOR, userName, cycleStatisticsValue);
            }else {
                indicatorStatisticsDao.updateCycleStatisticsValue(ACCOUNT_INDICATOR, userName, 0, new Date());
            }
        }
    }

    /**
     * 锁定账号
     *
     * @param userName
     */
    private void lockAccount(String userName){
        // 锁定账号
        accountDao.updateLockedStatus(userName, true);
        // 缓存失效
        cache.invalidate(userName);
    }
}
