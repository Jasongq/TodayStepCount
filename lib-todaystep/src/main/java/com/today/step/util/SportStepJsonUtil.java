package com.today.step.util;

import com.today.step.bean.TodayStepData;
import com.today.step.helper.TodayStepDBHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author : GuoQiang
 * e-mail : 849199845@qq.com
 * time   : 2022/01/07  15:27
 * desc   :
 * version: 1.0
 */
public class SportStepJsonUtil {
    public static final String SPORT_DATE = "sportDate";
    public static final String STEP_NUM = "stepNum";
    public static final String DISTANCE = "km";
    public static final String CALORIE = "kaluli";
    public static final String TODAY = TodayStepDBHelper.TODAY;

    public static JSONArray getSportStepJsonArray(List<TodayStepData> todayStepDataArrayList) {
        JSONArray jsonArray = new JSONArray();
        if (null == todayStepDataArrayList || 0 == todayStepDataArrayList.size()) {
            return jsonArray;
        }
        for (int i = 0; i < todayStepDataArrayList.size(); i++) {
            TodayStepData todayStepData = todayStepDataArrayList.get(i);
            try {
                JSONObject subObject = getJSONObject(todayStepData);
                jsonArray.put(subObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonArray;
    }

    public static JSONObject getJSONObject(TodayStepData todayStepData) throws JSONException {
        JSONObject subObject = new JSONObject();
        subObject.put(TODAY, todayStepData.getToday());
        subObject.put(SPORT_DATE, todayStepData.getDate()/1000);
        subObject.put(STEP_NUM, todayStepData.getStep());
        subObject.put(DISTANCE, getDistanceByStep(todayStepData.getStep()));
        subObject.put(CALORIE, getCalorieByStep(todayStepData.getStep()));
        return subObject;
    }

    // 公里计算公式
    public static String getDistanceByStep(long steps) {
        return String.format("%.2f", steps * 0.6f / 1000);
    }

    // 千卡路里计算公式
    public static String getCalorieByStep(long steps) {
        return String.format("%.1f", steps * 0.6f * 60 * 1.036f / 1000);
    }

}
