package com.today.step.util;

import android.content.Context;
import android.os.PowerManager;

import com.today.step.service.TodayStepService;

import java.util.Calendar;

/**
 * @author : GuoQiang
 * e-mail : 849199845@qq.com
 * time   : 2022/01/07  15:14
 * desc   :
 * version: 1.0
 */
public class WakeLockUtil {
    private static PowerManager.WakeLock mWakeLock;

    public synchronized static PowerManager.WakeLock getLock(Context context) {
        if (mWakeLock != null) {
            if (mWakeLock.isHeld())
                mWakeLock.release();
            mWakeLock = null;
        }

        if (null == mWakeLock) {
            PowerManager mgr = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            mWakeLock = mgr.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, TodayStepService.class.getName());
            mWakeLock.setReferenceCounted(true);
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(System.currentTimeMillis());
            mWakeLock.acquire();
        }
        return (mWakeLock);
    }
}
