package com.catfish.insect.utils;

import android.util.Log;

/**
 * Created by Lucia&Orlando on 2015/4/19.
 */
public class LOG {
    private static final String TAG = "digua";
    private static final boolean DEBUG = true;

    public static void d(String str) {
        if (DEBUG) {
            Log.d(TAG, str);
        }
    }

    public static void i(String str) {
        if (DEBUG) {
            Log.i(TAG, str);
        }
    }

    public static void w(String str) {
        Log.w(TAG, str);
    }

    public static void e(String str) {
        Log.e(TAG, str);
    }

    public static void e(String str, Throwable e) {
        Log.e(TAG, str, e);
    }
}
