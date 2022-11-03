package com.today.step.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.today.step.helper.PreferencesHelper;

/**
 * @author : GuoQiang
 * e-mail : 849199845@qq.com
 * time   : 2022/01/07  15:25
 * desc   : 停止 接收器
 * version: 1.0
 */
public class TodayStepShutdownReceiver  extends BroadcastReceiver {

    private static final String TAG = "TodayStepShutdownReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null!=intent && intent.getAction().equals(Intent.ACTION_SHUTDOWN)) {
            PreferencesHelper.setShutdown(context,true);
        }
    }
}
