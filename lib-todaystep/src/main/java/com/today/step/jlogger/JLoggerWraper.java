package com.today.step.jlogger;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.today.step.util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : GuoQiang
 * e-mail : 849199845@qq.com
 * time   : 2022/01/07  14:57
 * desc   :
 * version: 1.0
 */
public class JLoggerWraper {
    public static final void initXLog(Application application, String xlogPath) {
        String fileName = Util.getProcessName(application);
        try {
            fileName = fileName.replace(":", "_");
        } catch (Exception e) {
            e.printStackTrace();
            fileName = "xlog";
        }

//        JLoggerConfig jLoggerConfig = new JLoggerConfig.XlogBuilder(
//                application,
//                fileName,
//                xlogPath
//        )
//                .builder();
//        JLogger.init(jLoggerConfig);
    }

    public synchronized static final void onEventInfo(Context context, String eventID, String label) {
        if (!TextUtils.isEmpty(label)) {
//            JLogger.i(context.getPackageName(), String.format("%s : %s", eventID, label));
        } else {
//            JLogger.i(context.getPackageName(), eventID);

        }
    }

    public synchronized static final void onEventInfo(Context context, String eventID) {
        onEventInfo(context, eventID, "");
    }

    public synchronized static final void onEventInfo(Context context, String eventID, Map<String, String> map) {
        onEventInfo(context, eventID, map.toString());
    }

    public synchronized static final void flush() {
//        JLogger.flush();
    }

    public synchronized static final void deviceInfo(Context context) {
        Map<String, String> map = new HashMap<>();
        map.put("BRAND", Build.BRAND);  //samsung
        map.put("MANUFACTURER", Build.MANUFACTURER);//samsung
        map.put("MODEL", Build.MODEL);//SM-G9500
        map.put("PRODUCT", Build.PRODUCT);//dreamqltezc
        map.put("RELEASE", android.os.Build.VERSION.RELEASE);//8.0.0
        map.put("SDK_INT", String.valueOf(Build.VERSION.SDK_INT));//26
        map.put("APP_Version", Util.getAppVersion(context));
        map.put("APP_Build", Util.getAppVersionCode(context));
        //1. 手机具体型号，设备信息
        //2. 早上打开，晚上打开
        onEventInfo(context, JLoggerConstant.JLOGGER_DEVICE_INFO, map);
    }
}
