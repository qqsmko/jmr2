package com.jmr.security.listener;

import com.jmr.dao.TblAccountDao;
import com.jmr.dao.TblIndicatorStatisticsDao;
import com.jmr.model.TblIndicatorStatistics;
import com.jmr.security.AccountAuthorityCache;
import com.jmr.util.DateUtil;
import com.jmr.util.MonitorLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

import static com.jmr.util.MonitorNames.*;

/**
 * 账号登录失败事件监听
 * 如果连续三次密码输入失败，直接锁定账号
 *
 * Created by youtao.wan on 2017/6/8.
 */
@Component
public class LoginFailEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private static final Logger log = LoggerFactory.getLogger(LoginFailEventListener.class);

    private static final String ACCOUNT_INDICATOR = "login_fail";

    private static final String ACCOUNT_INDICATOR_CYCLE_TIME = "1d";

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
            initLoginFailIndicator(userName);

        }else {
            String timeStamp = DateUtil.toString(new Date(), "yyyy-MM-dd");

            int cycleStatisticsValue = indicatorStatistics.getCycleStatisticsValue();
            if (indicatorStatistics.isCycle()){
                // 账号在一个周期内连续3次登录失败，直接锁定账号
                if (cycleStatisticsValue > ACCOUNT_LOGIN_FAIL_LIMIT){
                    lockAccount(userName);
                    MonitorLog.error(log, BUSI_SECURITY, PROCESS_LOGIN, NODE_AUTHENTICATION, EVENT_AUTHENTICATION_FAIL, String.format("%s在%s连续三次登录失败，锁定账号", userName, timeStamp), DateUtil.toString(new Date(), "yyyyMMddHHmmss"));
                }

                cycleStatisticsValue += 1;
                indicatorStatisticsDao.updateCycleStatisticsValue(ACCOUNT_INDICATOR, userName, cycleStatisticsValue);
                MonitorLog.error(log, BUSI_SECURITY, PROCESS_LOGIN, NODE_AUTHENTICATION, EVENT_AUTHENTICATION_FAIL, String.format("%s在%s第%d次登录失败", userName, timeStamp, cycleStatisticsValue), DateUtil.toString(new Date(), "yyyyMMddHHmmss"));
            }else {
                indicatorStatisticsDao.updateCycleStatisticsValueAndTime(ACCOUNT_INDICATOR, userName, 0, new Date());
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

    /**
     * 初始化登录失败指标统计数据
     *
     * @param userName
     */
    private void initLoginFailIndicator(String userName){
        TblIndicatorStatistics indicatorStatistics = new TblIndicatorStatistics();
        indicatorStatistics.setIndicatorType(ACCOUNT_INDICATOR);
        indicatorStatistics.setIndicatorName(userName);
        indicatorStatistics.setCycleTime(ACCOUNT_INDICATOR_CYCLE_TIME);
        indicatorStatistics.setCycleStatisticsValue(1);
        indicatorStatistics.setUpdateTime(new Date());

        indicatorStatisticsDao.insert(indicatorStatistics);

        // 打印日志
        String timeStamp = DateUtil.toString(new Date(), "yyyy-MM-dd");
        MonitorLog.error(log, BUSI_SECURITY, PROCESS_LOGIN, NODE_AUTHENTICATION, EVENT_AUTHENTICATION_FAIL, String.format("%s在%s第1次登录失败", userName, timeStamp), DateUtil.toString(new Date(), "yyyyMMddHHmmss"));
    }
}
