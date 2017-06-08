package com.jmr.dao;

import com.jmr.model.TblIndicatorStatistics;

import java.util.Date;

/**
 * Created by youtao.wan on 2017/6/8.
 */
public interface TblIndicatorStatisticsDao {

    /**
     * 根据指标类型和指标名查询指标统计信息
     *
     * @param indicatorType
     * @param indicatorName
     * @return
     */
    TblIndicatorStatistics selectByTypeAndName(String indicatorType, String indicatorName);

    int insert(TblIndicatorStatistics indicatorStatistics);

    /**
     * 更新指标周期统计值
     *
     * @param indicatorType
     * @param indicatorName
     * @param newStatisticsValue
     * @return
     */
    int updateCycleStatisticsValue(String indicatorType, String indicatorName, int newStatisticsValue);

    /**
     * 更新指标周期统计值
     *
     * @param indicatorType
     * @param indicatorName
     * @param newStatisticsValue
     * @return
     */
    int updateCycleStatisticsValue(String indicatorType, String indicatorName, int newStatisticsValue, Date updateTime);
}
