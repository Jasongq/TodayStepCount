package com.today.stepdemo;

import android.content.Context;
import android.content.Intent;

import com.today.step.receiver.BaseClickBroadcast;

/**
 * @author : GuoQiang
 * e-mail : 849199845@qq.com
 * time   : 2022/01/07  16:04
 * desc   :
 * version: 1.0
 */
public class MyReceiver extends BaseClickBroadcast {
    @Override
    public void onReceive(Context context, Intent intent) {
        MyApplication tsApplication = (MyApplication) context.getApplicationContext();
        if (!tsApplication.isForeground()) {
            Intent mainIntent = new Intent(context, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mainIntent);
        } else {

        }
    }
}
