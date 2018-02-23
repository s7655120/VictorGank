package com.victor.gank.Utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * App信息相关工具类
 * Created by Victor on 2017/7/31.
 */
public class AppInfoUtils {

    /**
     * 获取当前App的PackageInfo
     * @param context
     * @return
     */
    private static PackageInfo getCurrentAppPackageInfo(Context context){
        try {
            PackageManager manager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo info = manager.getPackageInfo(packageName, 0);
            return info;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前app的版本名字.
     *
     * @param context
     * @return
     */
    public static String getAppVersionName(Context context) {
        PackageInfo info = getCurrentAppPackageInfo(context);
        String version = info.versionName;
        return version;
    }

    /**
     * 获取当前app的版本号.
     *
     * @param context
     * @return
     */
    public static int getAppVersionCode(Context context) {
        PackageInfo info = getCurrentAppPackageInfo(context);
        int versionCode = info.versionCode;
        return versionCode;
    }

}
