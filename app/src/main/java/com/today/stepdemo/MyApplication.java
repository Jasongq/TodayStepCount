package com.today.stepdemo;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

/**
 * @author : GuoQiang
 * e-mail : 849199845@qq.com
 * time   : 2022/01/07  16:05
 * desc   :
 * version: 1.0
 */
public class MyApplication extends Application {
    private static MyApplication sApplication;

    private int appCount = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        sApplication = this;

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                appCount++;
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                appCount--;
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });

    }

    /**
     * app是否在前台
     * @return true前台，false后台
     */
    public boolean isForeground(){
        return appCount > 0;
    }

    public static MyApplication getApplication() {
        return sApplication;
    }
}
