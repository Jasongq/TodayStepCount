package com.today.step.util;

import java.util.Date;
/**
 * @author : GuoQiang
 * e-mail : 849199845@qq.com
 * time   : 2022/01/07  15:27
 * desc   :
 * version: 1.0
 */
public class StepUtil {
    /**
     * 是否上传步数，23:55:50~00:05:50分无法上传步数
     *
     * @return true可以上传，false不能上传
     */
    public static boolean isUploadStep() {

        Date curDate = new Date(System.currentTimeMillis());

        long mills2355 = DateUtil.getDateMillis(DateUtil.getCurrentDate("yyyy-MM-dd") + " 23:55:50", "yyyy-MM-dd HH:mm:ss");
        Date date2355 = new Date(mills2355);

        if (curDate.after(date2355)) {
            return false;
        }

        long mills0005 = DateUtil.getDateMillis(DateUtil.getCurrentDate("yyyy-MM-dd") + " 00:05:50", "yyyy-MM-dd HH:mm:ss");
        Date date0005 = new Date(mills0005);

        if (curDate.before(date0005)) {
            return false;
        }

        return true;
    }

    /**
     * 是否先上传步数在跳转，23:59:00~00:01:00分直接跳转不上传步数
     *
     * @return true上传后跳转，false直接跳转
     */
    public static boolean isUploadStepGoto() {

        Date curDate = new Date(System.currentTimeMillis());

        long mills2355 = DateUtil.getDateMillis(DateUtil.getCurrentDate("yyyy-MM-dd") + " 23:59:00", "yyyy-MM-dd HH:mm:ss");
        Date date2355 = new Date(mills2355);

        if (curDate.after(date2355)) {
            return false;
        }

        long mills0005 = DateUtil.getDateMillis(DateUtil.getCurrentDate("yyyy-MM-dd") + " 00:01:00", "yyyy-MM-dd HH:mm:ss");
        Date date0005 = new Date(mills0005);

        if (curDate.before(date0005)) {
            return false;
        }

        return true;
    }

    /**
     * 23:30:00~00:05:00分隐藏tips
     *
     * @return true上传后跳转，false直接跳转
     */
    public static boolean isHealthTipsHide() {

        Date curDate = new Date(System.currentTimeMillis());

        long mills2355 = DateUtil.getDateMillis(DateUtil.getCurrentDate("yyyy-MM-dd") + " 23:30:00", "yyyy-MM-dd HH:mm:ss");
        Date date2355 = new Date(mills2355);

        if (curDate.after(date2355)) {
            return false;
        }

        long mills0005 = DateUtil.getDateMillis(DateUtil.getCurrentDate("yyyy-MM-dd") + " 00:05:00", "yyyy-MM-dd HH:mm:ss");
        Date date0005 = new Date(mills0005);

        if (curDate.before(date0005)) {
            return false;
        }

        return true;
    }
}
