package com.victor.gank.common.tools;

import android.text.TextUtils;

/**
 * Created by Victor on 2018/2/23.
 */

public class StringUtils {

    public static int toInt(String value) {
        if (TextUtils.isEmpty(value)) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }
}
