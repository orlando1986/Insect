package com.catfish.insect.module;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzhfang on 6/10/15.
 */
public class Task implements Runnable {
    private static List<Task> sTasks = new ArrayList<Task>();
    private Context mContext = null;

    public Task(Context context) {
        mContext = context.getApplicationContext();
        if (!sTasks.contains(this)) {
            sTasks.add(this);
        }
    }

    public static List<Task> getTasks() {
        return sTasks;
    }

    @Override
    public void run() {

    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        String thisName = getClass().getName();
        String objectName = object.getClass().getName();
        return thisName.equals(objectName);
    }
}
