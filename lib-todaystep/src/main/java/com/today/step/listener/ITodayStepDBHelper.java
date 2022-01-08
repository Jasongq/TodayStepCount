package com.today.step.listener;

import com.today.step.bean.TodayStepData;

import java.util.List;

/**
 * @author : GuoQiang
 * e-mail : 849199845@qq.com
 * time   : 2022/01/07  15:18
 * desc   :
 * version: 1.0
 */
public interface ITodayStepDBHelper {
    void createTable();

    void deleteTable();

    void clearCapacity(String curDate, int limit);

    boolean isExist(TodayStepData todayStepData);

    void insert(TodayStepData todayStepData);

    TodayStepData getMaxStepByDate(long millis);

    List<TodayStepData> getQueryAll();

    List<TodayStepData> getStepListByDate(String dateString);

    List<TodayStepData> getStepListByStartDateAndDays(String startDate, int days);
}
